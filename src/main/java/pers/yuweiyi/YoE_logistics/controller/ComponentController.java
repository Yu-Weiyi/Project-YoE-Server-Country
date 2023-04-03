package pers.yuweiyi.YoE_logistics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: ComponentController <br/>
 * description: 组件控制器。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 3/23/2023 9:58 AM <br/>
 */
@Controller
public class ComponentController {
    // 页面公共部分
    @RequestMapping("/component/header")
    public String header() {return "component/header";}

    @RequestMapping("/component/footer")
    public String component_footer() {return "component/footer";}

    @RequestMapping("/component/fixbar")
    public String component_fixbar() {return "component/fixbar";}
}
