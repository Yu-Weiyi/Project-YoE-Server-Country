package pers.yuweiyi.YoE_logistics.dao.vertex;

import org.apache.hugegraph.structure.graph.Vertex;
import pers.yuweiyi.YoE_logistics.enums.OrderStatusEnum;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.OrderPO;

import java.util.Date;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: OrderDAO <br/>
 * description: 数据库中对Order点操作接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/5/2023 4:34 PM <br/>
 */
public interface OrderDAO {
    Vertex insert(OrderPO orderPO);

    Vertex updateOrderStatusById(String id, OrderStatusEnum orderStatus);

    Vertex updateDatetimeEnd(String id, Date datetimeEnd);

    Vertex selectById(String id);
}
