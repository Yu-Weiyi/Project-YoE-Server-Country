package pers.yuweiyi.YoE_logistics.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.hugegraph.structure.graph.Path;
import org.apache.hugegraph.structure.graph.Vertex;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pers.yuweiyi.YoE_logistics.dao.edge.TransportFeeDAO;
import pers.yuweiyi.YoE_logistics.dao.graph.DataStorageDAO;
import pers.yuweiyi.YoE_logistics.dao.graph.PathPlanningDAO;
import pers.yuweiyi.YoE_logistics.dao.graph.impl.DataStorageDAOImpl;
import pers.yuweiyi.YoE_logistics.dao.graph.impl.PathPlanningDAOImpl;
import pers.yuweiyi.YoE_logistics.dao.vertex.OrderDAO;
import pers.yuweiyi.YoE_logistics.dao.vertex.ProvinceDAO;
import pers.yuweiyi.YoE_logistics.dao.vertex.StationDAO;
import pers.yuweiyi.YoE_logistics.dao.vertex.impl.OrderDAOImpl;
import pers.yuweiyi.YoE_logistics.dao.vertex.impl.StationDAOImpl;
import pers.yuweiyi.YoE_logistics.enums.CargoTypeEnum;
import pers.yuweiyi.YoE_logistics.enums.OrderStatusEnum;
import pers.yuweiyi.YoE_logistics.enums.OrderTypeEnum;
import pers.yuweiyi.YoE_logistics.enums.RecordTypeEnum;
import pers.yuweiyi.YoE_logistics.filter.GremlinFilter;
import pers.yuweiyi.YoE_logistics.pojo.dto.OrderDTO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.OrderPO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.RecordPO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.UserPO;
import pers.yuweiyi.YoE_logistics.pojo.vo.RecordVO;
import pers.yuweiyi.YoE_logistics.service.OrderControlService;
import pers.yuweiyi.YoE_logistics.util.SnowFlakeUtil;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: OrderControlServiceImpl <br/>
 * description: 订单控制服务实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 3/15/2023 2:07 PM <br/>
 */
@Service
public class OrderControlServiceImpl implements OrderControlService {

    @Override
    public void insertNewOrder(String orderId, int fee, OrderDTO orderDTO) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GremlinFilter gremlinFilter = new GremlinFilter();

        UserPO userPO = new UserPO(orderDTO);
        OrderPO orderPO = new OrderPO(orderId, fee, orderDTO);
        String provinceFrom = gremlinFilter.doFilter(orderDTO.getConsigner_province());
        String cityFrom = gremlinFilter.doFilter(orderDTO.getConsigner_city());
        String provinceTo = gremlinFilter.doFilter(orderDTO.getConsignee_province());
        String cityTo = gremlinFilter.doFilter(orderDTO.getConsignee_city());

        DataStorageDAO dataStorageDAO = (DataStorageDAOImpl) context.getBean("dataStorageDAOImpl");
        dataStorageDAO.insertNewOrder(userPO, orderPO, provinceFrom, cityFrom, provinceTo,cityTo);
        dataStorageDAO.insertFirstRecordByOrderId(orderId, new RecordPO(new Date(), RecordTypeEnum.EMPTY, "订单已注册，订单号[" + orderId + "]。"));
        dataStorageDAO.insertNewRecordByOrderId(orderId, new RecordPO(new Date(), RecordTypeEnum.START, "物流订单已接收，起始地[" + provinceFrom + cityFrom + orderDTO.getConsigner_address() + "]。"));
    }

    @Override
    public void insertNewOrder(OrderDTO orderDTO) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderControlService orderControlService = (OrderControlServiceImpl) context.getBean("orderControlServiceImpl");

        String order_id = SnowFlakeUtil.getDefaultSnowFlakeId().toString();
        int fee = orderControlService.calcFee(orderDTO.getConsigner_province(), orderDTO.getConsignee_province(), CargoTypeEnum.values()[Integer.parseInt(orderDTO.getCargo_type())], OrderTypeEnum.values()[Integer.parseInt(orderDTO.getOrder_type())]);

        insertNewOrder(order_id, fee, orderDTO);
    }


    @Override
    public int calcFee(String provinceFrom, String provinceTo, CargoTypeEnum cargoType, OrderTypeEnum orderType) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProvinceDAO provinceDAO = (ProvinceDAO) context.getBean("provinceDAOImpl");
        TransportFeeDAO transportFeeDAO = (TransportFeeDAO) context.getBean("transportFeeDAOImpl");

        int sum = 0;// = ( 基础服务费2 + 区间运输费？ + 【可选】冷链物流费2 )【可选】到付*2

        int basic = 2;
        int transport = (int) transportFeeDAO.select(provinceDAO.select(provinceFrom), provinceDAO.select(provinceTo)).property("fee");
        int cold = (cargoType == CargoTypeEnum.REFRIGERATED) ? 2 : 0;
        int pay = (orderType == OrderTypeEnum.CONSIGHEEPAY) ? 2 : 1;

        sum = (basic + transport + cold) * pay;

        return sum;
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

    @Override
    public void updateOrderRecord(String orderId, RecordTypeEnum recordType, String message) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataStorageDAO dataStorageDAO = (DataStorageDAOImpl) context.getBean("dataStorageDAOImpl");

        dataStorageDAO.insertNewRecordByOrderId(orderId, new RecordPO(new Date(), recordType, message));
    }

    @Override
    public void updateOrderWhenEnteringStation(String orderId, String stationName) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        OrderDAO orderDAO = (OrderDAOImpl) context.getBean("orderDAOImpl");
        Vertex orderVertex = orderDAO.selectById(orderId);

        updateOrderRecord(orderId, RecordTypeEnum.IN, "货物到达[" + stationName + "]。");

        DataStorageDAO dataStorageDAO = (DataStorageDAOImpl) context.getBean("dataStorageDAOImpl");
        Vertex finalStationVertex = dataStorageDAO.selectFinalStation(orderId);
        if ((String) finalStationVertex.property("name") == stationName){
            updateOrderRecord(orderId, RecordTypeEnum.IN,"货物已到达目的地[" + dataStorageDAO.selectProvinceTo(orderId) + dataStorageDAO.selectCityTo(orderId) + "]境内。");
        }
        else {
            StationDAO stationDAO = (StationDAOImpl) context.getBean("stationDAOImpl");
            Vertex nowStationVertex = stationDAO.selectByName(stationName);
            PathPlanningDAO pathPlanningDAO = (PathPlanningDAOImpl) context.getBean("pathPlanningDAOImpl");
            CargoTypeEnum cargoType = CargoTypeEnum.values()[((List<Integer>) orderVertex.property("cargoType")).iterator().next()];
            OrderTypeEnum orderType = OrderTypeEnum.values()[(int) orderVertex.property("orderType")];
            Vertex nextStationVertex = pathPlanningDAO.computeNextStation(nowStationVertex, finalStationVertex, cargoType, orderType);
            pathPlanningDAO.updateNextStation(orderVertex, nextStationVertex);
        }
    }

    @Override
    public void updateOrderWhenLeavingStation(String orderId, String stationName) {
        updateOrderRecord(orderId, RecordTypeEnum.OUT, "货物离开[" + stationName + "]。");
    }

    @Override
    public void updateOrderWhenErrorOccurred(String orderId, String message) {
        updateOrderRecord(orderId, RecordTypeEnum.ERROR, message);
    }

    @Override
    public void updateOrderWhenDelivering(String orderId, String stationName, String message) {
        updateOrderRecord(orderId, RecordTypeEnum.DELIVER, "货物开始派送，[" + stationName + "]派送员[" + message + "]。");
    }

    @Override
    public void updateOrderWhenReceived(String orderId) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        updateOrderRecord(orderId, RecordTypeEnum.RECEIVE, "货物已签收。");

        OrderDAO orderDAO = (OrderDAOImpl) context.getBean("orderDAOImpl");
        orderDAO.updateDatetimeEnd(orderId, new Date());
        orderDAO.updateOrderStatusById(orderId, OrderStatusEnum.FINISH);

        DataStorageDAO dataStorageDAO = (DataStorageDAOImpl) context.getBean("dataStorageDAOImpl");
        dataStorageDAO.archive(orderId);
    }

    @Override
    public void updateOrderWhenAgentReceived(String orderId, String message) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        updateOrderRecord(orderId, RecordTypeEnum.AGENT, "货物已被[" + message + "]代收。");

        OrderDAO orderDAO = (OrderDAOImpl) context.getBean("orderDAOImpl");
        orderDAO.updateDatetimeEnd(orderId, new Date());
        orderDAO.updateOrderStatusById(orderId, OrderStatusEnum.FINISH);

        DataStorageDAO dataStorageDAO = (DataStorageDAOImpl) context.getBean("dataStorageDAOImpl");
        dataStorageDAO.archive(orderId);
    }

    @Override
    public void updateOrderWhenNotFound(String orderId) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderDAO orderDAO = (OrderDAOImpl) context.getBean("orderDAOImpl");
        orderDAO.updateOrderStatusById(orderId, OrderStatusEnum.PREPARE);

        updateOrderRecord(orderId, RecordTypeEnum.MISS, "查无此人，即将联系寄件人。");
    }

    @Override
    public void updateOrderWhenRejected(String orderId) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderDAO orderDAO = (OrderDAOImpl) context.getBean("orderDAOImpl");
        orderDAO.updateOrderStatusById(orderId, OrderStatusEnum.REJECT);

        updateOrderRecord(orderId, RecordTypeEnum.REJECTION, "收件人拒收，即将联系寄件人。");
    }

    @Override
    public void updateOrderWhenSendBackConfirmed(String orderId) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderDAO orderDAO = (OrderDAOImpl) context.getBean("orderDAOImpl");
        orderDAO.updateOrderStatusById(orderId, OrderStatusEnum.CANCEL);

        DataStorageDAO dataStorageDAO = (DataStorageDAOImpl) context.getBean("dataStorageDAOImpl");
        dataStorageDAO.sendBack(orderId);

        Vertex orderVertex = orderDAO.selectById(orderId);
        updateOrderRecord(orderId, RecordTypeEnum.BACK, "寄件人确认，货物退回。原收件人为[" + (String) orderVertex.property("consigneeName") + "]，联系方式为[" + (String) orderVertex.property("consigneePhone") + "]。");
    }

    @Override
    public void updateOrderWhenAbandonConfirmed(String orderId) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        OrderDAO orderDAO = (OrderDAOImpl) context.getBean("orderDAOImpl");
        orderDAO.updateDatetimeEnd(orderId, new Date());
        orderDAO.updateOrderStatusById(orderId, OrderStatusEnum.FINISH);

        DataStorageDAO dataStorageDAO = (DataStorageDAOImpl) context.getBean("dataStorageDAOImpl");
        dataStorageDAO.archive(orderId);

        updateOrderRecord(orderId, RecordTypeEnum.BACK, "货物丢弃,货物已交由当地处理部门进行处理。");
    }
}
