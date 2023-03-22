package pers.yuweiyi.YoE_logistics.dao.edge.impl;

import org.apache.hugegraph.structure.graph.Edge;
import org.apache.hugegraph.structure.graph.Vertex;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.YoE_logistics.dao.edge.ArchiveDAO;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: ArchiveDAOImpl <br/>
 * description: 数据库中对Archive边操作实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/6/2023 9:22 PM <br/>
 */
@Repository("edgeArchiveDAOImpl")
public class ArchiveDAOImpl implements ArchiveDAO {

    @Override
    public Edge insert(@NotNull Vertex archive, @NotNull Vertex order) {
        Edge edge = archive.addEdge("archive", order);
        return edge;
    }
}
