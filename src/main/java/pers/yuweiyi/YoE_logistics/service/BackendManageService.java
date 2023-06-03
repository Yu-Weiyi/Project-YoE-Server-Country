package pers.yuweiyi.YoE_logistics.service;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: BackendManageService <br/>
 * description: 后台管理服务接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/25/2023 11:43 PM <br/>
 */
public interface BackendManageService {
    void updatePathWeight(String stationFromName, String stationToName, int newWeight);

    int searchPathWeight(String stationFromName, String stationToName);
}
