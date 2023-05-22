package pers.yuweiyi.YoE_logistics.dao.edge.impl;

import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.structure.graph.Edge;
import org.apache.hugegraph.structure.graph.Vertex;
import org.apache.hugegraph.structure.gremlin.ResultSet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.YoE_logistics.dao.edge.TransportFeeDAO;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

import java.util.Set;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: TransportFeeDAOImpl <br/>
 * description: 数据库中对TransportFee边操作实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 5/22/2023 4:25 PM <br/>
 */
@Repository
public class TransportFeeDAOImpl implements TransportFeeDAO {
    GremlinManager gremlin = GraphDatabaseUtil.gremlinManager;

    @Override
    public Edge update(Vertex sourceProvince, Vertex targetProvince, int newFee) {
        Edge edge = select(sourceProvince, targetProvince);
        edge = edge.property("fee", newFee);
        return edge;
    }

    @Override
    public Edge select(Vertex sourceProvince, Vertex targetProvince) {
        ResultSet resultSet = gremlin.gremlin(
                "g.E()." +
                  "hasLabel('transportFee')." +
                  "where(" +
                    "outV()." +
                    "has('province', 'name', '" + sourceProvince.property("name") + "'))." +
                  "where(" +
                    "inV()." +
                    "has('province', 'name', '" + targetProvince.property("name") + "'))"
        ).execute();
        Set<Edge> edgeSet = GraphDatabaseUtil.changeResultSetToEdgeSet(resultSet);
        if (edgeSet.iterator().hasNext()){
            return edgeSet.iterator().next();
        }
        return null;
    }
}
