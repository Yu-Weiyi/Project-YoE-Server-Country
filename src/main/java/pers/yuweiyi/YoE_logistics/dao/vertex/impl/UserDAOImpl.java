package pers.yuweiyi.YoE_logistics.dao.vertex.impl;

import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.structure.graph.Vertex;
import org.apache.hugegraph.structure.gremlin.ResultSet;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.YoE_logistics.dao.vertex.UserDAO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.UserPO;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

import java.util.Set;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: UserDAOImpl <br/>
 * description: 数据库中对User操作实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 1/26/2023 2:07 PM <br/>
 */
@Repository
public class UserDAOImpl implements UserDAO {
    GremlinManager gremlin = GraphDatabaseUtil.gremlinManager;

    @Override
    public Vertex insert(@NotNull UserPO userPO) {
        ResultSet resultSet = gremlin.gremlin(
                "g.addV('user')." +
                  "property('id', '" + userPO.getId() + "')." +
                  "property('name', '" + userPO.getName() + "')." +
                  "property('phone', '" + userPO.getPhone() + "')"
        ).execute();
        Set<Vertex> vertexSet = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet);
        if (vertexSet.iterator().hasNext()){
            return vertexSet.iterator().next();
        }
        return null;
    }

    @Override
    public Set<Vertex> selectById(String id) {
        ResultSet resultSet = gremlin.gremlin(
                "g.V()." +
                  "has('user', 'id', '" + id + "')"
        ).execute();
        Set<Vertex> vertexSet = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet);
        return vertexSet;
    }

    @Override
    public Set<Vertex> selectByPhone(String phone) {
        ResultSet resultSet = gremlin.gremlin(
                "g.V()." +
                  "has('user', 'phone', '" + phone + "')"
        ).execute();
        Set<Vertex> vertexSet = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet);
        return vertexSet;
    }
}
