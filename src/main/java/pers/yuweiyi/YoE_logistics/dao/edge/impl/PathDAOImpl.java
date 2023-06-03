package pers.yuweiyi.YoE_logistics.dao.edge.impl;

import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.structure.graph.Edge;
import org.apache.hugegraph.structure.graph.Vertex;
import org.apache.hugegraph.structure.gremlin.ResultSet;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.YoE_logistics.dao.edge.PathDAO;
import pers.yuweiyi.YoE_logistics.dao.vertex.StationDAO;
import pers.yuweiyi.YoE_logistics.dao.vertex.impl.StationDAOImpl;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

import java.util.Set;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: PathDAOImpl <br/>
 * description: 数据库中对Path边操作实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/7/2023 8:29 PM <br/>
 */
@Repository
public class PathDAOImpl implements PathDAO {
    GremlinManager gremlin = GraphDatabaseUtil.gremlinManager;

    @Override
    public Edge select(@NotNull Vertex sourceStation, @NotNull Vertex targetStation) {
        ResultSet resultSet = gremlin.gremlin(
                "g.E()." +
                  "hasLabel('path')." +
                  "where(" +
                    "outV()." +
                    "has('station', 'name', '" + sourceStation.property("name") + "'))." +
                  "where(" +
                    "inV()." +
                    "has('station', 'name', '" + targetStation.property("name") + "'))"
        ).execute();
        Set<Edge> edgeSet = GraphDatabaseUtil.changeResultSetToEdgeSet(resultSet);
        if (edgeSet.iterator().hasNext()){
            return edgeSet.iterator().next();
        }
        return null;
    }

    @Override
    public Edge select(String sourceStationName, String targetStationName) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StationDAO stationDAO = (StationDAOImpl) context.getBean("stationDAOImpl");
        PathDAO pathDAO = (PathDAOImpl) context.getBean("pathDAOImpl");

        Vertex stationFromVertex = stationDAO.selectByName(sourceStationName);
        Vertex stationToVertex = stationDAO.selectByName(targetStationName);

        Edge pathEdge = select(stationFromVertex, stationToVertex);

        return pathEdge;
    }


}
