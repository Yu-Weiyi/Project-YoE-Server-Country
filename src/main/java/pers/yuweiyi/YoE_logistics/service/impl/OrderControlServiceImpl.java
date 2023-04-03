package pers.yuweiyi.YoE_logistics.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.hugegraph.structure.graph.Path;
import org.apache.hugegraph.structure.graph.Vertex;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pers.yuweiyi.YoE_logistics.dao.graph.DataStorageDAO;
import pers.yuweiyi.YoE_logistics.dao.graph.impl.DataStorageDAOImpl;
import pers.yuweiyi.YoE_logistics.enums.RecordTypeEnum;
import pers.yuweiyi.YoE_logistics.pojo.dto.OrderDTO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.OrderPO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.RecordPO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.UserPO;
import pers.yuweiyi.YoE_logistics.pojo.vo.RecordVO;
import pers.yuweiyi.YoE_logistics.service.OrderControlService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
    public void insertNewOrder(String orderId, int fee, OrderDTO orderDTO) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserPO userPO = new UserPO(orderDTO);
        OrderPO orderPO = new OrderPO(orderId, fee, orderDTO);
        String provinceFrom = orderDTO.getConsigner_province();
        String cityFrom = orderDTO.getConsigner_city();
        String provinceTo = orderDTO.getConsignee_province();
        String cityTo = orderDTO.getConsignee_city();

        DataStorageDAO dataStorageDAO = (DataStorageDAOImpl) context.getBean("dataStorageDAOImpl");
        dataStorageDAO.insertNewOrder(userPO, orderPO, provinceFrom, cityFrom, provinceTo,cityTo);
        dataStorageDAO.insertFirstRecordByOrderId(orderId, new RecordPO(new Date(), RecordTypeEnum.EMPTY, "订单已注册，订单号[" + orderId + "]。"));
        dataStorageDAO.insertNewRecordByOrderId(orderId, new RecordPO(new Date(), RecordTypeEnum.START, "物流订单已接收，起始地[" + provinceFrom + cityFrom + orderDTO.getConsigner_address() + "]。"));
    }

    @Override
    public int calcFee(String provinceFrom, String porvinceTo) {
        return 5; //test fee项 计划更改为根据两地与货物类型，订单类型等在服务器端计算得出。
    }

    @Override
    public List<RecordVO> searchOrderRecords(String orderId) throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataStorageDAO dataStorageDAO = (DataStorageDAOImpl) context.getBean("dataStorageDAOImpl");

        List<RecordVO> recordVOList = new LinkedList<RecordVO>();

        Path recordsPath = dataStorageDAO.selectRecordsByOrderId(orderId);
        List recordObjectsList = recordsPath.objects();

        for (int i = 0; i < recordObjectsList.size(); i++){
            Vertex recordVertex = (Vertex) recordObjectsList.get(i);
            RecordPO recordPO = new RecordPO(recordVertex);
            RecordVO recordVO = new RecordVO(recordPO);

            recordVOList.add(recordVO);
        }

        return recordVOList;
    }
}
