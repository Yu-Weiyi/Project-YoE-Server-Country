package pers.yuweiyi.YoE_logistics.pojo.po.vertex;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.hugegraph.structure.graph.Vertex;
import org.jetbrains.annotations.NotNull;
import pers.yuweiyi.YoE_logistics.enums.RecordTypeEnum;

import java.util.Date;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: RecordEntity <br/>
 * description: 记录点数据项。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/3/2023 9:04 PM <br/>
 */
@Data
@AllArgsConstructor
public class RecordPO {
    @NotNull private Date datetime;//时间
    @NotNull private RecordTypeEnum recordType;//记录类型
    @NotNull private String name;//内容

    public RecordPO(@NotNull Vertex vertex){
        this.datetime = (Date) vertex.property("datetime");
        this.recordType = RecordTypeEnum.valueOf((String) vertex.property("recordType"));
        this.name = (String) vertex.property("name");
    }
}
