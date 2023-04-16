package pers.yuweiyi.YoE_logistics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: PageController <br/>
 * description: 页面控制器。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 3/19/2023 6:36 PM <br/>
 */
@Controller
public class PageController {
    // 首页
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/about/author_Yu_Weiyi")
    public String about_author() {
        return "about/author_Yu_Weiyi";
    }

    @RequestMapping("/about/project_YoE")
    public String about_project() {
        return "about/project_YoE";
    }

    @RequestMapping("/rule/limit")
    public String limit_rule() {
        return "rule/limit";
    }

    @RequestMapping("/rule/fee")
    public String fee_rule() {
        return "rule/fee";
    }

    @RequestMapping("/order/place")
    public String place_order() {
        return "order/place";
    }

    @RequestMapping("/order/place_with_employee")
    public String place_order_employee_assistance() {
        return "order/place_with_employee";
    }

    @RequestMapping("/order/search")
    public String search_order() {
        return "order/search";
    }

    @RequestMapping("/domestic/speedpost")
    public String domestic_speedpost() {
        return "domestic/speedpost";
    }

    @RequestMapping("/domestic/cold_chain_logistics")
    public String domestic_cold_chain_logistics() {
        return "domestic/cold_chain_logistics";
    }

    @RequestMapping("/domestic/offsite_warehousing")
    public String domestic_offsite_warehousing() {
        return "domestic/offsite_warehousing";
    }

    @RequestMapping("/international/air_mailing")
    public String international_air_mailing() {
        return "international/air_mailing";
    }

    @RequestMapping("/international/bulk_shipping")
    public String international_bulk_shipping() {
        return "international/bulk_shipping";
    }
}
