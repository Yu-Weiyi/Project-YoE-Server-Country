package pers.yuweiyi.YoE_logistics.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.yuweiyi.YoE_logistics.enums.CargoTypeEnum;
import pers.yuweiyi.YoE_logistics.enums.OrderTypeEnum;
import pers.yuweiyi.YoE_logistics.enums.RecordTypeEnum;
import pers.yuweiyi.YoE_logistics.pojo.dto.OrderDTO;
import pers.yuweiyi.YoE_logistics.pojo.dto.OrderUpdateDTO;
import pers.yuweiyi.YoE_logistics.pojo.vo.OrderIdVO;
import pers.yuweiyi.YoE_logistics.pojo.vo.RecordVO;
import pers.yuweiyi.YoE_logistics.service.OrderControlService;
import pers.yuweiyi.YoE_logistics.service.impl.OrderControlServiceImpl;
import pers.yuweiyi.YoE_logistics.util.SnowFlakeUtil;

import java.util.List;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: OrderController <br/>
 * description: 订单控制器。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 3/21/2023 2:00 PM <br/>
 */
@Controller
//@RestController
@RequestMapping("/order")
public class OrderController {
    @RequestMapping(value = "/place_order", method = RequestMethod.POST)
    @ResponseBody
    public String place_order(@RequestBody OrderDTO orderDTO) throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderControlService orderControlService = (OrderControlServiceImpl) context.getBean("orderControlServiceImpl");

        String order_id = SnowFlakeUtil.getDefaultSnowFlakeId().toString();
        int fee = orderControlService.calcFee(orderDTO.getConsigner_province(), orderDTO.getConsignee_province(), CargoTypeEnum.values()[Integer.parseInt(orderDTO.getCargo_type())], OrderTypeEnum.values()[Integer.parseInt(orderDTO.getOrder_type())]);

        orderControlService.insertNewOrder(order_id, fee, orderDTO);

        ObjectMapper mapper = new ObjectMapper();
        OrderIdVO orderIdVO = new OrderIdVO(order_id, Integer.toString(fee));
        String res = mapper.writeValueAsString(orderIdVO);//把user对象转换成字符串
        return res;
    }

    @RequestMapping(value = "/search_order/{order_id}", method = RequestMethod.GET)
    @ResponseBody
    public String search_order(@PathVariable("order_id") String orderId) throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderControlService orderControlService = (OrderControlServiceImpl) context.getBean("orderControlServiceImpl");

        List<RecordVO> recordVOList = orderControlService.searchOrderRecords(orderId);

        ObjectMapper mapper = new ObjectMapper();
        String res = mapper.writeValueAsString(recordVOList);

        return res;
    }

    @RequestMapping(value = "/update_order", method = RequestMethod.POST)
    @ResponseBody
    public String update_order(@RequestBody OrderUpdateDTO orderUpdateDTO) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderControlService orderControlService = (OrderControlServiceImpl) context.getBean("orderControlServiceImpl");

        String orderId = orderUpdateDTO.getOrder_id();
        RecordTypeEnum recordType = RecordTypeEnum.values()[Integer.parseInt(orderUpdateDTO.getRecord_type())];
        String stationName = orderUpdateDTO.getStation_name();
        String message = orderUpdateDTO.getMessage();

        switch (recordType) {
            case IN:
                orderControlService.updateOrderWhenEnteringStation(orderId, stationName);
                break;
            case OUT:
                orderControlService.updateOrderWhenLeavingStation(orderId, stationName);
                break;
            case ERROR:
                orderControlService.updateOrderWhenErrorOccurred(orderId, message);
                break;
            case DELIVER:
                orderControlService.updateOrderWhenDelivering(orderId, stationName, message);
                break;
            case RECEIVE:
                orderControlService.updateOrderWhenReceived(orderId);
                break;
            case AGENT:
                orderControlService.updateOrderWhenAgentReceived(orderId, message);
                break;
            case MISS:
                orderControlService.updateOrderWhenNotFound(orderId);
                break;
            case REJECTION:
                orderControlService.updateOrderWhenRejected(orderId);
                break;
            case BACK:
                orderControlService.updateOrderWhenSendBackConfirmed(orderId);
                break;
            case ABANDON:
                orderControlService.updateOrderWhenAbandonConfirmed(orderId);
                break;
            default:
                break;
        }

        return "done";//useless
    }
}
