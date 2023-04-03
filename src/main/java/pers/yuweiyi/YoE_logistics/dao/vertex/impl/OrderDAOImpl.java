package pers.yuweiyi.YoE_logistics.dao.vertex.impl;

import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.structure.graph.Vertex;
import org.apache.hugegraph.structure.gremlin.ResultSet;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.YoE_logistics.dao.vertex.OrderDAO;
import pers.yuweiyi.YoE_logistics.enums.OrderStatusEnum;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.OrderPO;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

import java.util.Date;
import java.util.Set;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: OrderDAOImpl <br/>
 * description: 数据库中对Order操作实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/5/2023 4:52 PM <br/>
 */
@Repository
public class OrderDAOImpl implements OrderDAO {
    GremlinManager gremlin = GraphDatabaseUtil.gremlinManager;

    @Override
    public Vertex insert(@NotNull OrderPO orderPO) {
        ResultSet resultSet = gremlin.gremlin(
                "g.addV('order')." +
                        "property('id', '" + orderPO.getId() + "')." +
                        "property('orderType', " + orderPO.getOrderType().ordinal() + ")." +
                        "property('status', " + orderPO.getOrderStatus().ordinal() + ")." +
                        "property('fee', " + orderPO.getFee() + ")." +
                        "property('cargoType', " + orderPO.getCargoType().ordinal() + ")." +
                        "property('information', '" + orderPO.getInformation() + "')." +
                        "property('inspect', '" + orderPO.getInspect() + "')." +
                        "property('addressFrom', '" + orderPO.getAddressFrom() + "')." +
                        "property('addressTo', '" + orderPO.getAddressTo() + "')." +
                        "property('consigneeName', '" + orderPO.getConsigneeName() + "')." +
                        "property('consigneePhone', '" + orderPO.getConsigneePhone() + "')." +
                        "property('datetimeStart', " + orderPO.getDatetimeStart().getTime() + ")"
                //此处未插入结束时间datetimeEnd
        ).execute();
        Set<Vertex> vertexSet = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet);
        if (vertexSet.iterator().hasNext()){
            return vertexSet.iterator().next();
        }
        return null;
    }

    @Override
    public Vertex updateOrderStatusById(String id, @NotNull OrderStatusEnum orderStatus) {
        Vertex vertex = selectById(id);
        vertex = vertex.property("status", orderStatus.ordinal());
        return vertex;
    }

    @Override
    public Vertex updateDatetimeEnd(String id, @NotNull Date datetimeEnd) {
        Vertex vertex = selectById(id);
        vertex = vertex.property("datetimeEnd", datetimeEnd.getTime());
        return vertex;
    }

    @Override
    public Vertex selectById(String id) {
        ResultSet resultSet = gremlin.gremlin(
                "g.V()" +
                 ".has('order', 'id', '" + id + "')"
        ).execute();
        Set<Vertex> vertexSet = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet);
        if (vertexSet.iterator().hasNext()){
            return vertexSet.iterator().next();
        }
        return null;
    }
}
