package pers.yuweiyi.YoE_logistics.dao.edge;

import org.apache.hugegraph.structure.graph.Edge;
import org.apache.hugegraph.structure.graph.Vertex;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: TransportFeeDAO <br/>
 * description: 数据库中对TransportFee边操作接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 5/22/2023 4:19 PM <br/>
 */
public interface TransportFeeDAO {
    public Edge update(Vertex sourceProvince, Vertex targetProvince, int newFee);

    public Edge select(Vertex sourceProvince, Vertex targetProvince);
}
