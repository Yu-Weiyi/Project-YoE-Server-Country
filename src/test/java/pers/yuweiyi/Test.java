package pers.yuweiyi;

import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.driver.HugeClient;
import org.apache.hugegraph.structure.graph.Vertex;
import org.apache.hugegraph.structure.gremlin.ResultSet;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

import java.util.Set;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: Test <br/>
 * description: 此处添加描述 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 此处添加版本 <br/>
 * @since 3/22/2023 9:13 PM <br/>
 */
public class Test {
    public static  void main(String[] args) {
        HugeClient client = HugeClient.builder("http://172.18.206.194:8080", "hugegraph").build();
        System.out.println(client);
        GremlinManager gremlin = client.gremlin();
        ResultSet resultSet = gremlin.gremlin(
                "g.V('64:A1a站')"
        ).execute();
        Set<Vertex> vertexSet = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet);
        if (vertexSet.iterator().hasNext()) {
            System.out.println(vertexSet.iterator().next().id());
        }
    }
}
