package pers.yuweiyi.YoE_logistics.dao.graph.impl;

import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.structure.graph.Edge;
import org.apache.hugegraph.structure.graph.Path;
import org.apache.hugegraph.structure.graph.Vertex;
import org.apache.hugegraph.structure.gremlin.ResultSet;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.YoE_logistics.dao.edge.*;
import pers.yuweiyi.YoE_logistics.dao.edge.impl.*;
import pers.yuweiyi.YoE_logistics.dao.graph.DataStorageDAO;
import pers.yuweiyi.YoE_logistics.dao.graph.PathPlanningDAO;
import pers.yuweiyi.YoE_logistics.dao.vertex.*;
import pers.yuweiyi.YoE_logistics.dao.vertex.ArchiveDAO;
import pers.yuweiyi.YoE_logistics.dao.vertex.impl.*;
import pers.yuweiyi.YoE_logistics.dao.vertex.impl.ArchiveDAOImpl;
import pers.yuweiyi.YoE_logistics.enums.RecordTypeEnum;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.OrderPO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.RecordPO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.UserPO;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

import java.util.List;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: DataStorageDAOImpl <br/>
 * description: 数据库中对有关数据存储操作实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/8/2023 10:16 PM <br/>
 */
@Repository
public class DataStorageDAOImpl implements DataStorageDAO {
    GremlinManager gremlin = GraphDatabaseUtil.gremlinManager;

    @Override
    public void insertNewOrder(UserPO userPO, OrderPO orderPO, String provinceFrom, String cityFrom, String provinceTo, String cityTo) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDAO userDAO = (UserDAOImpl) context.getBean("userDAOImpl");
        Vertex userVertex = userDAO.insert(userPO);

        OrderDAO orderDAO = (OrderDAOImpl) context.getBean("orderDAOImpl");
        Vertex orderVertex = orderDAO.insert(orderPO);

        PlaceDAO placeDAO = (PlaceDAOImpl) context.getBean("placeDAOImpl");
        placeDAO.insert(userVertex, orderVertex);

        ProvinceDAO provinceDAO = (ProvinceDAOImpl) context.getBean("provinceDAOImpl");
        Vertex provinceFromVertex = provinceDAO.select(provinceFrom);
        Vertex provinceToVertex = provinceDAO.select(provinceTo);

        ProvinceFromDAO provinceFromDAO = (ProvinceFromDAOImpl) context.getBean("provinceFromDAOImpl");
        provinceFromDAO.insert(orderVertex, provinceFromVertex);

        ProvinceToDAO provinceToDAO  = (ProvinceToDAOImpl) context.getBean("provinceToDAOImpl");
        provinceToDAO.insert(orderVertex, provinceToVertex);

        CityDAO cityDAO = (CityDAOImpl) context.getBean("cityDAOImpl");
        Vertex cityFromVertex = cityDAO.select(cityFrom);
        Vertex cityToVertex = cityDAO.select(cityTo);

        CityFromDAO cityFromDAO = (CityFromDAOImpl) context.getBean("cityFromDAOImpl");
        cityFromDAO.insert(orderVertex, cityFromVertex);

        CityToDAO cityToDAO = (CityToDAOImpl) context.getBean("cityToDAOImpl");
        cityToDAO.insert(orderVertex, cityToVertex);

        PathPlanningDAO pathPlanningDAO = (PathPlanningDAOImpl) context.getBean("pathPlanningDAOImpl");
        Vertex nextStationVertex = pathPlanningDAO.searchNearestTargetStation(cityFromVertex);
        Vertex finalStationVertex = pathPlanningDAO.searchNearestTargetStation(cityToVertex);

        NextStationDAO nextStationDAO = (NextStationDAOImpl) context.getBean("nextStationDAOImpl");
        nextStationDAO.insert(orderVertex, nextStationVertex);

        FinalStationDAO finalStationDao = (FinalStationDAOImpl) context.getBean("finalStationDAOImpl");
        finalStationDao.insert(orderVertex, finalStationVertex);
    }

    @Override
    public Vertex insertFirstRecordByOrderId(String orderId, @NotNull RecordPO record) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        OrderDAO orderDAO = (OrderDAOImpl) context.getBean("orderDAOImpl");
        Vertex order = orderDAO.selectById(orderId);

        RecordDAO recordDAO = (RecordDAOImpl) context.getBean("recordDAOImpl");
        Vertex emptyRecord = recordDAO.insert(new RecordPO(record.getDatetime(), RecordTypeEnum.EMPTY, orderId));
        Vertex firstRecord = recordDAO.insert(record);

        StartRecordDAO startRecordDAO = (StartRecordDAOImpl) context.getBean("startRecordDAOImpl");
        Edge startRecord = startRecordDAO.insert(order, emptyRecord);

        NextRecordDAO nextRecordDAO = (NextRecordDAOImpl) context.getBean("nextRecordDAOImpl");
        Edge tailRecord = nextRecordDAO.insert(emptyRecord, firstRecord);

        return firstRecord;
    }

    @Override
    public Vertex insertNewRecordByOrderId(String orderId, RecordPO newRecord) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        List<Object> oldRecords = selectRecordsByOrderId(orderId).objects();
        Vertex tailRecord = (Vertex) oldRecords.get(oldRecords.size() - 1);

        RecordDAO recordDAO = (RecordDAOImpl) context.getBean("recordDAOImpl");
        Vertex newTailRecord = recordDAO.insert(newRecord);

        NextRecordDAO nextRecordDAO = (NextRecordDAOImpl) context.getBean("nextRecordDAOImpl");
        nextRecordDAO.insert(tailRecord, newTailRecord);

        return newTailRecord;
    }

    @Override
    public Path selectRecordsByOrderId(String orderId) {
        ResultSet resultSet = gremlin.gremlin(
                "g.V()." +
                  "has('order', 'id', '" + orderId + "')." +
                  "out('startRecord')." +
                  "repeat(out()).emit(hasLabel('record'))." +
                  "path()." +
                  "tail(1)"
        ).execute();
        Path path = GraphDatabaseUtil.changeResultSetToPathSet(resultSet).iterator().next();

        path = GraphDatabaseUtil.cutPathFromHead(path, 2);//去除头部Order的部分,但仍至少剩余一个空的Record。
        return path;
    }

    @Override
    public Vertex selectFinalStation(String orderId) {
        ResultSet resultSet = gremlin.gremlin(
                "g.V()." +
                  "has('order', 'id', '" + orderId + "')." +
                  "out('finalStation')"
        ).execute();
        Vertex vertex = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet).iterator().next();
        return vertex;
    }

    @Override
    public Vertex selectProvinceFrom(String orderId) {
        ResultSet resultSet = gremlin.gremlin(
                "g.V()." +
                  "has('order', 'id', '" + orderId + "')." +
                  "out('provinceFrom')"
        ).execute();
        Vertex vertex = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet).iterator().next();
        return vertex;
    }

    @Override
    public Vertex selectCityFrom(String orderId) {
        ResultSet resultSet = gremlin.gremlin(
                "g.V()." +
                  "has('order', 'id', '" + orderId + "')." +
                  "out('cityFrom')"
        ).execute();
        Vertex vertex = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet).iterator().next();
        return vertex;
    }


    @Override
    public Vertex selectProvinceTo(String orderId) {
        ResultSet resultSet = gremlin.gremlin(
                "g.V()." +
                  "has('order', 'id', '" + orderId + "')." +
                  "out('provinceTo')"
        ).execute();
        Vertex vertex = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet).iterator().next();
        return vertex;
    }

    @Override
    public Vertex selectCityTo(String orderId) {
        ResultSet resultSet = gremlin.gremlin(
                "g.V()." +
                  "has('order', 'id', '" + orderId + "')." +
                  "out('cityTo')"
        ).execute();
        Vertex vertex = GraphDatabaseUtil.changeResultSetToVertexSet(resultSet).iterator().next();
        return vertex;
    }

    @Override
    public void archive(String orderId) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        OrderDAO orderDAO = (OrderDAOImpl) context.getBean("orderDAOImpl");
        Vertex orderVertex = orderDAO.selectById(orderId);

        NextStationDAO nextStationDAO = (NextStationDAOImpl) context.getBean("nextStationDAOImpl");
        nextStationDAO.delete(orderVertex);

        FinalStationDAO finalStationDAO = (FinalStationDAOImpl) context.getBean("finalStationDAOImpl");
        finalStationDAO.delete(orderVertex);

        ProvinceFromDAO provinceFromDAO = (ProvinceFromDAOImpl) context.getBean("provinceFromDAOImpl");
        provinceFromDAO.delete(orderVertex);

        ProvinceToDAO provinceToDAO = (ProvinceToDAOImpl) context.getBean("provinceToDAOImpl");
        provinceToDAO.delete(orderVertex);

        CityFromDAO cityFromDAO = (CityFromDAOImpl) context.getBean("cityFromDAOImpl");
        cityFromDAO.delete(orderVertex);

        CityToDAO cityToDAO = (CityToDAOImpl) context.getBean("cityToDAOImpl");
        cityToDAO.delete(orderVertex);

        //TODO archive链表
    }

    @Override
    public void sendBack(String orderId) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        OrderDAO orderDAO = (OrderDAOImpl) context.getBean("orderDAOImpl");
        Vertex orderVertex = orderDAO.selectById(orderId);

        Vertex provinceFromVertex = selectProvinceFrom(orderId);
        ProvinceToDAO provinceToDAO = (ProvinceToDAOImpl) context.getBean("provinceToDAOImpl");
        provinceToDAO.delete(orderVertex);
        provinceToDAO.insert(orderVertex, provinceFromVertex);

        PathPlanningDAO pathPlanningDAO = (PathPlanningDAOImpl) context.getBean("pathPlanningDAOImpl");

        Vertex cityFromVertex = selectCityFrom(orderId);
        Vertex oldCityToVertex = selectCityTo(orderId);
        CityToDAO cityToDAO = (CityToDAOImpl) context.getBean("cityToDAOImpl");
        cityToDAO.delete(orderVertex);
        cityToDAO.insert(orderVertex, cityFromVertex);

        FinalStationDAO finalStationDAO = (FinalStationDAOImpl) context.getBean("finalStationDAOImpl");
        finalStationDAO.delete(orderVertex);
        Vertex newFinalStationVertex = pathPlanningDAO.searchNearestTargetStation(cityFromVertex);
        finalStationDAO.insert(orderVertex, newFinalStationVertex);

        NextStationDAO nextStationDAO = (NextStationDAOImpl) context.getBean("nextStationDAOImpl");
        nextStationDAO.delete(orderVertex);
        Vertex newNextStationVertex = pathPlanningDAO.searchNearestTargetStation(oldCityToVertex);
        nextStationDAO.insert(orderVertex, newNextStationVertex);
    }


}
