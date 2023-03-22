package pers.yuweiyi.YoE_logistics.dao.vertex;

import org.apache.hugegraph.structure.graph.Vertex;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.ArchivePO;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: ArchiveDAO <br/>
 * description: 数据库中对Archive点操作接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/3/2023 8:27 PM <br/>
 */
public interface ArchiveDAO {
    Vertex insert(ArchivePO archivePO);

    void delete(ArchivePO archivePO);

    Vertex select(ArchivePO archivePO);
}
