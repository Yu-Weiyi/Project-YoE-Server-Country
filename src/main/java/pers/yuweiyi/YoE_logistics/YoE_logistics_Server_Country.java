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
 * @version 0.1 <br/>
 * @since 1/23/2023 3:13 PM <br/>
 */
@Slf4j
public class YoE_logistics_Server_Country {
    public static void main(String[] args){
        log.info("YoE-logistics-Server-Country: Program start");

//        //Spring context
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        //Database
//        GraphDatabaseUtil graphDatabaseUtil = (GraphDatabaseUtil) context.getBean("graphDatabaseUtil");
////        graphDatabaseUtil.openConnection();


        //初始化（仅运行一次）
//        GraphDatabaseUtil.initializeData();


        //TEST



        //TODO 修改gremlin格式

        //TODO 补全entities，dao，impl等包                -ing
            //补充graph.DataStorage, Graph.PathPlanning
            //准备对接services包业务
        //TODO 设计相关对象
        //TODO 补全services包                            -ing
        //TODO 编写socket操作 SocketUtil
        //TODO 编写运行处理流程
        //TODO 架设程序主体：启动/循环/终止

        //TODO 归档整理线程
        //TODO 连接处理线程
        //TODO 数据库通信线程

        //结束
//        graphDatabaseUtil.closeConnection();

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
