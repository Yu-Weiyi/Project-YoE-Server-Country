package pers.yuweiyi.YoE_logistics.dao.edge.impl;

import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.structure.graph.Edge;
import org.apache.hugegraph.structure.graph.Vertex;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.YoE_logistics.dao.edge.CityToDAO;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: CityToDAOImpl <br/>
 * description: 数据库中对CityTo边操作实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/6/2023 10:19 PM <br/>
 */
@Repository
public class CityToDAOImpl implements CityToDAO {
    GremlinManager gremlin = GraphDatabaseUtil.gremlinManager;

    @Override
    public Edge insert(@NotNull Vertex order, @NotNull Vertex city) {
        Edge edge = order.addEdge("cityTo", city);
        return edge;
    }

    @Override
    public void delete(@NotNull Vertex order) {
        gremlin.gremlin(
                "g.V('" + order.id().toString() + "')." +
                  "outE('cityTo')." +
                  "drop()"
        ).execute();
    }
}
