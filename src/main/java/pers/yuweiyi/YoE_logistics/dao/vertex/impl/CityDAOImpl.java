package pers.yuweiyi.YoE_logistics.dao.vertex.impl;

import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.structure.graph.Vertex;
import org.apache.hugegraph.structure.gremlin.ResultSet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.YoE_logistics.dao.vertex.CityDAO;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

import java.util.Set;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: CityDAOImpl <br/>
 * description: 数据库中对City点操作实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/6/2023 10:43 PM <br/>
 */
@Repository
public class CityDAOImpl implements CityDAO {
    GremlinManager gremlin = GraphDatabaseUtil.gremlinManager;

    @Override
    public Vertex select(String name) {
        ResultSet resultSet = gremlin.gremlin(
                "g.V()." +
                  "has('city', 'name', '" + name + "')"
        ).execute();
        Set<Vertex> vertexSet = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet);
        if (vertexSet.iterator().hasNext()){
            return vertexSet.iterator().next();
        }
        return null;
    }
}
