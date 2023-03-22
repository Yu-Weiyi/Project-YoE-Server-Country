package pers.yuweiyi.YoE_logistics.service;

import pers.yuweiyi.YoE_logistics.pojo.dto.OrderDTO;


/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: OrderControlService <br/>
 * description: 订单控制服务接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/9/2023 9:49 PM <br/>
 */
public interface OrderControlService {
    void insertNewOrder(OrderDTO orderDTO);
}
