package pers.yuweiyi.YoE_logistics.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: OrderIdVO <br/>
 * description: 订单单号与费用视图对象。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 3/23/2023 3:44 PM <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderIdVO {
    private String order_id;
    private String fee;
}
