package pers.yuweiyi.YoE_logistics.dao.vertex.impl;

import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.structure.graph.Vertex;
import org.apache.hugegraph.structure.gremlin.ResultSet;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.YoE_logistics.dao.vertex.RecordDAO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.RecordPO;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

import java.util.Set;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: RecordDAOImpl <br/>
 * description: 数据库中对Record操作实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/3/2023 9:30 PM <br/>
 */
@Repository
public class RecordDAOImpl implements RecordDAO {
    GremlinManager gremlin = GraphDatabaseUtil.gremlinManager;

    @Override
    public Vertex insert(@NotNull RecordPO recordPO) {
        ResultSet resultSet = gremlin.gremlin(
                "g.addV('record')." +
                  "property('datetime', " + recordPO.getDatetime().getTime() + ")." +
                  "property('recordType', " + recordPO.getRecordType().ordinal() + ")." +
                  "property('name', '" + recordPO.getName() + "')"
        ).execute();
        Set<Vertex> vertexSet = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet);
        if (vertexSet.iterator().hasNext()){
            return vertexSet.iterator().next();
        }
        return null;
    }
}
