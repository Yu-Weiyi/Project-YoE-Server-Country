package pers.yuweiyi.YoE_logistics.dao.vertex;

import org.apache.hugegraph.structure.graph.Vertex;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: StationDAO <br/>
 * description: 数据库中对Station点操作接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/6/2023 11:21 PM <br/>
 */
public interface StationDAO {
    Vertex selectByName(String name);
}
