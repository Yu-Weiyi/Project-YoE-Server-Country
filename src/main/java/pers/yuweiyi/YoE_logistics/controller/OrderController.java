package pers.yuweiyi.YoE_logistics.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.yuweiyi.YoE_logistics.dao.graph.DataStorageDAO;
import pers.yuweiyi.YoE_logistics.dao.graph.impl.DataStorageDAOImpl;
import pers.yuweiyi.YoE_logistics.pojo.dto.OrderDTO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.OrderPO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.UserPO;
import pers.yuweiyi.YoE_logistics.service.OrderControlService;
import pers.yuweiyi.YoE_logistics.service.impl.OrderControlServiceImpl;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: OrderController <br/>
 * description: 订单控制器。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>x
 * @since 3/21/2023 2:00 PM <br/>
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @RequestMapping(value = "/place_order", method = RequestMethod.POST)
    @ResponseBody
    public String place_order(@RequestBody OrderDTO orderDTO) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        OrderControlService orderControlService = (OrderControlServiceImpl) context.getBean("orderControlServiceImpl");
        orderControlService.insertNewOrder(orderDTO);

        return " :) ";  // ???
    }
}
