package pers.yuweiyi.YoE_logistics.init;

import lombok.extern.slf4j.Slf4j;
import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.driver.SchemaManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: GraphDatabasePreviousDataCleaner <br/>
 * description: 图数据库旧有数据清除器。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 1/31/2023 10:49 PM <br/>
 */
@Slf4j
public class GraphDatabasePreviousDataCleaner {
    public void cleanPreviousData(){
        String databaseName = GraphDatabaseUtil.databaseName;
        SchemaManager schema = GraphDatabaseUtil.schemaManager;
        GremlinManager gremlin = GraphDatabaseUtil.gremlinManager;

        //清除图数据
        gremlin.gremlin("g.V().drop()").execute();
        log.info("Graph Database {} Graph Data: Clear", databaseName);
    }
}
