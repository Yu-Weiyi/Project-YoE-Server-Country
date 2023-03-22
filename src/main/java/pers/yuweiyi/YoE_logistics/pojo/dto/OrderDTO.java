package pers.yuweiyi.YoE_logistics.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: OrderDTO <br/>
 * description: 订单数据传输对象。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 3/21/2023 3:05 PM <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @NotNull private String employee_account_id;
    @NotNull private String employee_account_password;
    @NotNull private String consigner_name;
    @NotNull private String consigner_id;
    @NotNull private String consigner_phone;
    @NotNull private String consignee_name;
    @NotNull private String consignee_phone;
    @NotNull private String cargo_info;
    @NotNull private String cargo_type;
    @NotNull private String inspect;
    @NotNull private String consigner_province;
    @NotNull private String consigner_city;
    @NotNull private String consigner_address;
    @NotNull private String consignee_province;
    @NotNull private String consignee_city;
    @NotNull private String consignee_address;
    @NotNull private String order_type;
}
