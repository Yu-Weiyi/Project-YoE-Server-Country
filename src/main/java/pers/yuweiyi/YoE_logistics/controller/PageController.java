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
    // 首页
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

//    // 页面公共部分
//    @RequestMapping("/component/header")
//    public String component_header() {return "";}
//
//    @RequestMapping("/component/footer")
//    public String component_footer() {return "component/footer";}
//
//    @RequestMapping("/component/fixbar")
//    public String component_fixbar() {return "component/fixbar";}

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

    @RequestMapping("/search_order")
    public String search_order() {
        return "search_order";
    }

    // TEST
    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
