package pers.yuweiyi.YoE_logistics.dao.edge.impl;

import org.apache.hugegraph.structure.graph.Edge;
import org.apache.hugegraph.structure.graph.Vertex;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.YoE_logistics.dao.edge.PlaceDAO;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: PlaceDAOImpl <br/>
 * description: 数据库中对Place边操作实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/6/2023 8:46 PM <br/>
 */
@Repository
public class PlaceDAOImpl implements PlaceDAO {

    @Override
    public Edge insert(@NotNull Vertex user, @NotNull Vertex order) {
        Edge edge = user.addEdge("place", order);
        return edge;
    }
}
