package pers.yuweiyi.YoE_logistics.pojo.po.vertex;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.hugegraph.structure.graph.Vertex;
import org.jetbrains.annotations.NotNull;
import pers.yuweiyi.YoE_logistics.enums.CargoTypeEnum;
import pers.yuweiyi.YoE_logistics.enums.OrderStatusEnum;
import pers.yuweiyi.YoE_logistics.enums.OrderTypeEnum;
import pers.yuweiyi.YoE_logistics.pojo.dto.OrderDTO;
import pers.yuweiyi.YoE_logistics.util.SnowFlakeUtil;

import java.util.Date;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: OrderEntity <br/>
 * description: 订单点数据项。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/5/2023 3:40 PM <br/>
 */
@Data
@AllArgsConstructor
public class OrderPO {
    @NotNull
    private String id;//订单号
    @NotNull
    private OrderTypeEnum orderType;//订单类型
    @NotNull
    private OrderStatusEnum orderStatus;//订单状态
    @NotNull
    private int fee;//运费

    @NotNull
    private CargoTypeEnum cargoType;//货物类型
    @NotNull
    private String information;//信息（名称|规格|重量）
    @NotNull
    private String inspect;//验视（验视机构|验视人）

    @NotNull
    private String addressFrom;//寄件地址
    @NotNull
    private String addressTo;//收件地址

    @NotNull
    private String consigneeName;//收件人姓名
    @NotNull
    private String consigneePhone;//收件人电话

    @NotNull
    private Date datetimeStart;//订单开始时间
    private Date datetimeEnd;//订单结束时间

    public OrderPO(@NotNull Vertex vertex) {
        this.id = (String) vertex.property("id");
        this.orderType = OrderTypeEnum.valueOf((String) vertex.property("orderType"));
        this.orderStatus = OrderStatusEnum.valueOf((String) vertex.property("status"));
        this.fee = (int) vertex.property("fee");
        this.cargoType = CargoTypeEnum.valueOf((String) vertex.property("cargoType"));
        this.information = (String) vertex.property("information");
        this.inspect = (String) vertex.property("inspect");
        this.addressFrom = (String) vertex.property("addressFrom");
        this.addressTo = (String) vertex.property("addressTo");
        this.consigneeName = (String) vertex.property("consigneeName");
        this.consigneePhone = (String) vertex.property("consigneePhone");
        this.datetimeStart = new Date((long) vertex.property("datetimeStart"));
        if (vertex.property("datetimeEnd") == null) {
            this.datetimeEnd = null;
        } else {
            this.datetimeEnd = new Date((long) vertex.property("datetimeEnd"));
        }
    }

    public OrderPO(@NotNull String orderId, @NotNull int fee, @NotNull OrderDTO orderDTO) {
        this.id = orderId;
        this.orderType = OrderTypeEnum.values()[Integer.parseInt(orderDTO.getOrder_type())];
        this.orderStatus = OrderStatusEnum.PREPARE;
        this.fee = fee; //test fee项 计划更改为根据两地与货物类型，订单类型等在服务器端计算得出。
        this.cargoType = CargoTypeEnum.values()[Integer.parseInt(orderDTO.getCargo_type())];
        this.information = orderDTO.getCargo_info();
        this.inspect = orderDTO.getInspect();
        this.addressFrom = orderDTO.getConsigner_address();
        this.addressTo = orderDTO.getConsignee_address();
        this.consigneeName = orderDTO.getConsignee_name();
        this.consigneePhone = orderDTO.getConsignee_phone();
        this.datetimeStart = new Date();
        this.datetimeEnd = null;
    }
}
