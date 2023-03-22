package pers.yuweiyi.YoE_logistics.pojo.po.vertex;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.hugegraph.structure.graph.Vertex;
import org.jetbrains.annotations.NotNull;
import pers.yuweiyi.YoE_logistics.enums.CargoTypeEnum;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: StationPO <br/>
 * description: 站点点数据项。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/6/2023 11:08 PM <br/>
 */
@Data
@AllArgsConstructor
public class StationPO {
    @NotNull private String name;
    @NotNull private int level;
    @NotNull private CargoTypeEnum cargoType;

    public StationPO(@NotNull Vertex vertex){
        this.name = (String) vertex.property("name");
        this.level = (int) vertex.property("level");
        this.cargoType = CargoTypeEnum.valueOf((String) vertex.property("cargoType"));
    }
}
