package pers.yuweiyi.YoE_logistics.dao.edge;

import org.apache.hugegraph.structure.graph.Edge;
import org.apache.hugegraph.structure.graph.Vertex;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: NextStationDAO <br/>
 * description: 数据库中对NextStation边操作接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/7/2023 7:33 PM <br/>
 */
public interface NextStationDAO {
    Edge insert(Vertex order, Vertex station);

    void delete(Vertex order);
}
