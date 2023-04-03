package pers.yuweiyi.YoE_logistics.pojo.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import pers.yuweiyi.YoE_logistics.enums.RecordTypeEnum;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.RecordPO;

import java.util.Date;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: RecordVO <br/>
 * description: 订单单条记录视图对象。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 3/24/2023 2:18 PM <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordVO {
    private String datetime;
    private String type;
    private String msg;

    public RecordVO(@NotNull RecordPO recordPO) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        this.datetime = mapper.writeValueAsString(recordPO.getDatetime());

        // 转义 zh_CN
        RecordTypeEnum recordType = recordPO.getRecordType();
        switch (recordType) {
            case EMPTY:
                this.type = "成功注册";
                break;
            case START:
                this.type = "开始订单";
                break;
            case IN:
                this.type = "货物入站";
                break;
            case OUT:
                this.type = "货物出站";
                break;
            case ERROR:
                this.type = "发生错误";
                break;
            case DELIVER:
                this.type = "正在投递";
                break;
            case RECEIVE:
                this.type = "成功交付";
                break;
            case AGENT:
                this.type = "成功代收";
                break;
            case MISS:
                this.type = "查无此人";
                break;
            case REJECTION:
                this.type = "客户拒收";
                break;
            case BACK:
                this.type = "原路退回";
                break;
            case ABANDON:
                this.type = "丢弃处理";
                break;
            default:
                this.type = "发生错误";
                break;
        }

        this.msg = recordPO.getName();
    }
}
