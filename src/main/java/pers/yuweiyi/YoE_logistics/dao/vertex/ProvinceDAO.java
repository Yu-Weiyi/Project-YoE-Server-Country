package pers.yuweiyi.YoE_logistics.dao.vertex;

import org.apache.hugegraph.structure.graph.Vertex;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: ProvinceDAO <br/>
 * description: 数据库中对Province点操作接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/6/2023 10:33 PM <br/>
 */
public interface ProvinceDAO {
    Vertex select(String name);
}
