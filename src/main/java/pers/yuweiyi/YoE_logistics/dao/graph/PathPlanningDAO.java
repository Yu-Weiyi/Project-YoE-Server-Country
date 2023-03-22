package pers.yuweiyi.YoE_logistics.dao.graph;

import org.apache.hugegraph.structure.graph.Vertex;
import pers.yuweiyi.YoE_logistics.enums.CargoTypeEnum;
import pers.yuweiyi.YoE_logistics.enums.OrderTypeEnum;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: PathPlanningDAO <br/>
 * description: 数据库中对有关路线规划操作接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/8/2023 11:25 PM <br/>
 */
public interface PathPlanningDAO {
    Vertex searchNearestTargetStation(Vertex city);

    Vertex computeNextStation(Vertex nowStation, Vertex targetStation, CargoTypeEnum cargoType, OrderTypeEnum orderType);
}
