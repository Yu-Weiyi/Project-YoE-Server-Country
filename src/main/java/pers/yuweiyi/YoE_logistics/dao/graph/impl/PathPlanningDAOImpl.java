package pers.yuweiyi.YoE_logistics.dao.graph.impl;

import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.structure.graph.Edge;
import org.apache.hugegraph.structure.graph.Path;
import org.apache.hugegraph.structure.graph.Vertex;
import org.apache.hugegraph.structure.gremlin.ResultSet;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.YoE_logistics.dao.edge.NextStationDAO;
import pers.yuweiyi.YoE_logistics.dao.edge.impl.NextStationDAOImpl;
import pers.yuweiyi.YoE_logistics.dao.graph.PathPlanningDAO;
import pers.yuweiyi.YoE_logistics.enums.CargoTypeEnum;
import pers.yuweiyi.YoE_logistics.enums.OrderTypeEnum;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

import java.util.List;
import java.util.Set;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: PathPlanningDAOImpl <br/>
 * description: 数据库中对有关路线规划操作实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/10/2023 10:12 PM <br/>
 */
@Repository
public class PathPlanningDAOImpl implements PathPlanningDAO {
    GremlinManager gremlin = GraphDatabaseUtil.gremlinManager;

    @Override
    public Vertex searchNearestTargetStation(@NotNull Vertex city) {
        ResultSet resultSet = gremlin.gremlin(
                "g.V('" + city.id() + "')." +
                  "choose(" +
                    "out('set')." +
                    "count())." +
                "option(1," +
                  "out('set'))." +
                "option(0," +
                  "repeat(" +
                    "out('adjacentCity'))." +
                  "until(" +
                    "out('set')." +
                    "count()." +
                    "is(neq(0)))." +
                  "out('set')." +
                  "limit(1))." +
                "option(none," +
                  "out('set')." +
                  "limit(1))"
        ).execute();
        Set<Vertex> vertexSet = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet);
        if (vertexSet.iterator().hasNext()){
            return vertexSet.iterator().next();
        }
        return null;
    }

    @Override
    public Vertex computeNextStation(@NotNull Vertex nowStation, @NotNull Vertex targetStation, CargoTypeEnum cargoType, OrderTypeEnum orderType) {
        Vertex nextStation = null;

        Path path = null;
        int distance = 0;
        Path tempPath = null;
        int tempDistance = 0;

        if (nowStation.property("name") == targetStation.property("name")){
            nextStation = targetStation;
        }
        else {
            ResultSet resultSet;
            if (cargoType == CargoTypeEnum.COMMON) {
                resultSet = gremlin.gremlin(
                        "g.V('" + nowStation.id() + "')." +
                          "repeat(" +
                            "outE('path')." +
                            "has('pathType',0)." +
                            "inV())." +
                          "until(" +
                            "hasId('" + targetStation.id() + "'))." +
                          "path()." +
                          "limit(3)"
                ).execute();
            }
            else {
                resultSet = gremlin.gremlin(
                        "g.V('" + nowStation.id() + "')." +
                          "repeat(" +
                            "outE('path')." +
                            "inV())." +
                          "until(" +
                            "hasId('" + targetStation.id() + "'))." +
                          "path()." +
                          "limit(3)"
                ).execute();
            }
            Set<Path> pathSet = GraphDatabaseUtil.changeResultSetToPathSet(resultSet);
            if (pathSet.iterator().hasNext()){
                path = pathSet.iterator().next();
                distance = computeWeightedDIstanceBetweenStations(path);
            }
            int i = 0;
            while (pathSet.iterator().hasNext()){
                i++;
                tempPath = pathSet.iterator().next();
                tempDistance = computeWeightedDIstanceBetweenStations(tempPath);
                if (distance > tempDistance){
                    path = tempPath;
                    distance = tempDistance;
                }
                if (i >= 3) {
                    break;
                }
            }
            List<Object> list = path.objects();
            nextStation = (Vertex) list.get(2);
        }
        return nextStation;
    }

    @Override
    public int computeWeightedDIstanceBetweenStations(@NotNull Path path) {
        int sum = 0;
        List<Object> items = path.objects();
        for (int i = 1; i < items.size(); i += 2){
            sum += (int) (((Edge) (items.get(i))).property("costDistance"));
        }
        return sum;
    }

    @Override
    public Edge updateNextStation(Vertex order, Vertex nextStation) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        NextStationDAO nextStationDAO = (NextStationDAOImpl) context.getBean("nextStationDAOImpl");
        nextStationDAO.delete(order);
        Edge edge = nextStationDAO.insert(order, nextStation);
        return edge;
    }

}
