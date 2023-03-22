package pers.yuweiyi.YoE_logistics.dao.vertex.impl;

import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.structure.graph.Vertex;
import org.apache.hugegraph.structure.gremlin.ResultSet;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.YoE_logistics.dao.vertex.ArchiveDAO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.ArchivePO;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

import java.util.Set;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: ArchiveDAOImpl <br/>
 * description: 数据库中对Archive操作实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/3/2023 8:40 PM <br/>
 */
@Repository("vertexArchiveDAOImpl")
public class ArchiveDAOImpl implements ArchiveDAO {
    GremlinManager gremlin = GraphDatabaseUtil.gremlinManager;

    @Override
    public Vertex insert(@NotNull ArchivePO archivePO) {
        ResultSet resultSet = gremlin.gremlin(
                "g.addV('archive')." +
                  "property('year', '" + archivePO.getYear() + "')." +
                  "property('month', '" + archivePO.getMonth() + "')"
        ).execute();
        Set<Vertex> vertexSet = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet);
        if (vertexSet.iterator().hasNext()){
            return vertexSet.iterator().next();
        }
        return null;
    }

    @Override
    public void delete(@NotNull ArchivePO archivePO) {
        gremlin.gremlin(
                "g.V()." +
                  "hasLabel('archive')." +
                  "has('year', " + archivePO.getYear() + ")." +
                  "has('month', " + archivePO.getMonth() + ")." +
                  "drop()"
        ).execute();
    }

    @Override
    public Vertex select(@NotNull ArchivePO archivePO) {
        ResultSet resultSet = gremlin.gremlin(
                "g.V()." +
                  "hasLabel('archive')." +
                  "has('year', " + archivePO.getYear() + ")." +
                  "has('month', " + archivePO.getMonth() + ")." +
                  "drop()"
        ).execute();
        Set<Vertex> vertexSet = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet);
        if (vertexSet.iterator().hasNext()){
            return vertexSet.iterator().next();
        }
        return null;
    }
}
