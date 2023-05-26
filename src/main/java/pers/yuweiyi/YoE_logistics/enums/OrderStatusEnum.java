package pers.yuweiyi.YoE_logistics.enums;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: OrderStatusEnum <br/>
 * description: 订单状态枚举。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 1/26/2023 1:20 PM <br/>
 */
public enum OrderStatusEnum {
                //过程
    PREPARE,        //准备
    SENDING,        //运输
                //结果
    LOST,           //丢失
    CANCEL,         //取消
    FINISH,         //结束
    REJECT          //拒收

}
