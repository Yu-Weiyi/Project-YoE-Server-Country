package pers.yuweiyi.YoE_logistics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: YoE_logistics_Server_Country <br/>
 * description: 程序主入口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 1/23/2023 3:13 PM <br/>
 */
@Slf4j
public class YoE_logistics_Server_Country {
    public static void main(String[] args){
        log.info("YoE-logistics-Server-Country: Program start");

        //初始化（仅运行一次）
        GraphDatabaseUtil.initializeData();


        //TEST



        //TODO ___Enum.valueOf(String) -> ___Enum.values()[int]

        //TODO __DTO extends DTO (abstract class)

        //TODO 归档整理线程
        //TODO 连接处理线程
        //TODO 数据库通信线程

        log.info("YoE-logistics-Server-Country: Program end");

        //TODO 以下为毕设修改规划：
        //省市主键由name替换为id，沿用政府编码。
        //行政区划完全重置？
        //初始化使用pf4j插件实现。
        //TODO 以下为本系列其它规划：
        //设置省级服务器？
        //价格计算使用pf4j插件实现。
    }
}
