package pers.yuweiyi.YoE_logistics.dao.graph;

import org.apache.hugegraph.structure.graph.Path;
import org.apache.hugegraph.structure.graph.Vertex;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.OrderPO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.RecordPO;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.UserPO;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: DataStorageDAO <br/>
 * description: 数据库中对有关数据存储操作接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/8/2023 10:14 PM <br/>
 */
public interface DataStorageDAO {
    void insertNewOrder(UserPO userPO, OrderPO orderPO, String provinceFrom, String cityFrom, String provinceTo, String cityTo);

    Vertex insertFirstRecordByOrderId(String orderId, RecordPO record);

    Vertex insertNewRecordByOrderId(String orderId, RecordPO newRecord);

    Path selectRecordsByOrderId(String orderId);

    Vertex selectFinalStation(String orderId);

    Vertex selectProvinceFrom(String orderId);

    Vertex selectCityFrom(String orderId);

    Vertex selectProvinceTo(String orderId);

    Vertex selectCityTo(String orderId);

    void archive(String orderId);

    void sendBack(String orderId);
}
