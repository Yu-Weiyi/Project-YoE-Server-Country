package pers.yuweiyi.YoE_logistics.pojo.po.edge;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.hugegraph.structure.graph.Vertex;
import org.jetbrains.annotations.NotNull;
import pers.yuweiyi.YoE_logistics.enums.PathTypeEnum;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: PathPO <br/>
 * description: 路径边数据项。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/7/2023 8:07 PM <br/>
 */
@Data
@AllArgsConstructor
public class PathPO {
    @NotNull Vertex sourceStation;
    @NotNull Vertex targetStation;

    @NotNull PathTypeEnum pathType;
    @NotNull int costDistance;
    @NotNull int costTime;
}
