package pers.yuweiyi.YoE_logistics.dao.graph.impl;

import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.structure.graph.Path;
import org.apache.hugegraph.structure.graph.Vertex;
import org.apache.hugegraph.structure.gremlin.ResultSet;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
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
        //TODO 此处暂未考虑距离因素
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
        Path path = null;

        if (nowStation.property("name") == targetStation.property("name"))
        if (cargoType == CargoTypeEnum.COMMON) {
            // TODO 此处暂未考虑权重
            ResultSet resultSet = gremlin.gremlin(
                    "g.V('" + nowStation.id() + "')." +
                      "repeat(" +
                        "outE()." +
                        "has('path','pathType',0)." +
                        "inV())." +
                      "until(" +
                        "hasId('" + targetStation.id() + "'))." +
                      "path()." +
                      "limit(1)"
            ).execute();
            Set<Path> pathSet = GraphDatabaseUtil.changeResultSetToPathSet(resultSet);
            if (pathSet.iterator().hasNext()){
                path = pathSet.iterator().next();
            }
        }
        else {
            // TODO 此处暂未考虑权重
            ResultSet resultSet = gremlin.gremlin(
                    "g.V('" + nowStation.id() + "')." +
                            "repeat(" +
                            "outE()." +
                            "inV())." +
                            "until(" +
                            "hasId('" + targetStation.id() + "'))." +
                            "path()." +
                            "limit(1)"
            ).execute();
            Set<Path> pathSet = GraphDatabaseUtil.changeResultSetToPathSet(resultSet);
            if (pathSet.iterator().hasNext()){
                path = pathSet.iterator().next();
            }
        }

        List<Object> list = path.objects();
        return (Vertex) list.get(2);
    }
}
