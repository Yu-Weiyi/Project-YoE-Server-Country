package pers.yuweiyi.YoE_logistics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: PageController <br/>
 * description: 页面控制器。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 3/19/2023 6:36 PM <br/>
 */
@Controller
public class PageController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/not_implemented")
    public String not_implemented() {
        return "not_implemented";
    }

    @RequestMapping("/about_author")
    public String about_author() {
        return "about_author";
    }

    @RequestMapping("/about_project")
    public String about_project() {
        return "about_project";
    }

    @RequestMapping("/limit_rule")
    public String limit_rule() {
        return "limit_rule";
    }

    @RequestMapping("/fee_rule")
    public String fee_rule() {
        return "fee_rule";
    }

    @RequestMapping("/place_order")
    public String place_order() {
        return "place_order";
    }

    @RequestMapping("/place_order_employee_assistance")
    public String place_order_employee_assistance() {
        return "place_order_employee_assistance";
    }
}
