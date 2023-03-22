package pers.yuweiyi.YoE_logistics.dao.edge.impl;

import org.apache.hugegraph.structure.graph.Edge;
import org.apache.hugegraph.structure.graph.Vertex;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.YoE_logistics.dao.edge.StartRecordDAO;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: StartRecordDAOImpl <br/>
 * description: 数据库中对StartRecord边操作实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/6/2023 9:08 PM <br/>
 */
@Repository
public class StartRecordDAOImpl implements StartRecordDAO {

    @Override
    public Edge insert(@NotNull Vertex order, @NotNull Vertex record) {
        Edge edge = order.addEdge("startRecord", record);
        return edge;
    }
}
