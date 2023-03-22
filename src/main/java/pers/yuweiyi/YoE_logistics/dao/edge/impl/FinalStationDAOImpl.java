package pers.yuweiyi.YoE_logistics.dao.edge.impl;

import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.structure.graph.Edge;
import org.apache.hugegraph.structure.graph.Vertex;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.YoE_logistics.dao.edge.FinalStationDAO;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: FinalStationDAOImpl <br/>
 * description: 数据库中对FinalStation边操作实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/9/2023 8:50 PM <br/>
 */
@Repository
public class FinalStationDAOImpl implements FinalStationDAO {
    GremlinManager gremlin = GraphDatabaseUtil.gremlinManager;

    @Override
    public Edge insert(@NotNull Vertex order, @NotNull Vertex station) {
        Edge edge = order.addEdge("finalStation", station);
        return edge;
    }

    @Override
    public void delete(@NotNull Vertex order) {
        gremlin.gremlin(
                "g.V('" + order.id().toString() + "')." +
                  "outE('finalStation')." +
                  "drop()"
        ).execute();
    }
}
