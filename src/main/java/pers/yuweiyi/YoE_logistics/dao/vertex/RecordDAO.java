package pers.yuweiyi.YoE_logistics.dao.vertex;

import org.apache.hugegraph.structure.graph.Vertex;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.RecordPO;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: RecordDAO <br/>
 * description: 数据库中对Record点操作接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/3/2023 9:21 PM <br/>
 */
public interface RecordDAO {
    Vertex insert(RecordPO recordPO);
}
