package pers.yuweiyi.YoE_logistics.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pers.yuweiyi.YoE_logistics.dao.graph.DataStorageDAO;
import pers.yuweiyi.YoE_logistics.dao.graph.impl.DataStorageDAOImpl;
import pers.yuweiyi.YoE_logistics.pojo.dto.OrderDTO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.OrderPO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.UserPO;
import pers.yuweiyi.YoE_logistics.service.OrderControlService;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: OrderControlServiceImpl <br/>
 * description: 订单控制服务实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 3/15/2023 2:07 PM <br/>
 */
@Service
public class OrderControlServiceImpl implements OrderControlService {

    @Override
    public void insertNewOrder(OrderDTO orderDTO) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserPO userPO = new UserPO(orderDTO);
        OrderPO orderPO = new OrderPO(orderDTO);
        String provinceFrom = orderDTO.getConsigner_province();
        String cityFrom = orderDTO.getConsigner_city();
        String provinceTo = orderDTO.getConsignee_province();
        String cityTo = orderDTO.getConsignee_city();

        DataStorageDAO dataStorageDAO = (DataStorageDAOImpl) context.getBean("dataStorageDAOImpl");
        dataStorageDAO.insertNewOrder(userPO, orderPO, provinceFrom, cityFrom, provinceTo,cityTo);
    }
}
