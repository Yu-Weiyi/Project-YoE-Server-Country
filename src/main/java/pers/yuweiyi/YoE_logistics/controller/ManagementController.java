package pers.yuweiyi.YoE_logistics.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.yuweiyi.YoE_logistics.enums.RecordTypeEnum;
import pers.yuweiyi.YoE_logistics.pojo.dto.OrderUpdateDTO;
import pers.yuweiyi.YoE_logistics.pojo.dto.PathWeightUpdateDTO;
import pers.yuweiyi.YoE_logistics.service.BackendManageService;
import pers.yuweiyi.YoE_logistics.service.OrderControlService;
import pers.yuweiyi.YoE_logistics.service.impl.BackendManageServiceImpl;
import pers.yuweiyi.YoE_logistics.service.impl.OrderControlServiceImpl;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: ManagementController <br/>
 * description: 管理控制器。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/25/2023 10:18 PM <br/>
 */
@Controller
//@RestController
@RequestMapping("/manage")
public class ManagementController {
    @RequestMapping(value = "/update_path_weight", method = RequestMethod.POST)
    @ResponseBody
    public String update_path_weight(@RequestBody PathWeightUpdateDTO pathWeightUpdateDTO) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BackendManageService backendManageService = (BackendManageServiceImpl) context.getBean("backendManageServiceImpl");
        backendManageService.updatePathWeight(pathWeightUpdateDTO.getStation_from(), pathWeightUpdateDTO.getStation_to(), Integer.parseInt(pathWeightUpdateDTO.getNew_weight()));

        return "done";//useless
    }
}
