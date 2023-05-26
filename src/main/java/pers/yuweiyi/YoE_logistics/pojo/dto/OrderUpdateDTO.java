package pers.yuweiyi.YoE_logistics.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: OrderUpdateDTO <br/>
 * description: 订单更新传输对象。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 5/24/2023 11:11 AM <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderUpdateDTO {
    @NotNull private String order_id;
    @NotNull private String record_type;
    @NotNull private String station_name;
    @NotNull private String message;
}
