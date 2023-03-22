package pers.yuweiyi.YoE_logistics.init;

import lombok.extern.slf4j.Slf4j;
import org.apache.hugegraph.driver.SchemaManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import pers.yuweiyi.YoE_logistics.util.GraphDatabaseUtil;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: GraphDatabaseSchemaDataInitializer <br/>
 * description: 图数据库元数据初始化器。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 1/31/2023 7:56 PM <br/>
 */
@Slf4j
public class GraphDatabaseSchemaDataInitializer {
    public void initializeSchemaData(){
        String databaseName = GraphDatabaseUtil.databaseName;
        SchemaManager schema = GraphDatabaseUtil.schemaManager;

        //创建属性
        schema.propertyKey("id")
                .asText()
                .ifNotExist().create();
        schema.propertyKey("name")
                .asText()
                .ifNotExist().create();
        schema.propertyKey("consigneeName")
                .asText()
                .ifNotExist().create();
        schema.propertyKey("status")
                .asInt()
                .ifNotExist().create();
        schema.propertyKey("cargoType")
                .asInt().valueSet()
                .ifNotExist().create();
        schema.propertyKey("orderType")
                .asInt()
                .ifNotExist().create();
        schema.propertyKey("pathType")
                .asInt()
                .ifNotExist().create();
        schema.propertyKey("recordType")
                .asInt()
                .ifNotExist().create();
        schema.propertyKey("phone")
                .asText()
                .ifNotExist().create();
        schema.propertyKey("consigneePhone")
                .asText()
                .ifNotExist().create();
        schema.propertyKey("password")
                .asText()
                .ifNotExist().create();
        schema.propertyKey("addressFrom")
                .asText()
                .ifNotExist().create();
        schema.propertyKey("addressTo")
                .asText()
                .ifNotExist().create();
        schema.propertyKey("datetime")
                .asLong()
                .ifNotExist().create();
        schema.propertyKey("datetimeStart")
                .asLong()
                .ifNotExist().create();
        schema.propertyKey("datetimeEnd")
                .asLong()
                .ifNotExist().create();
        schema.propertyKey("information")
                .asText()
                .ifNotExist().create();
        schema.propertyKey("level")
                .asInt()
                .ifNotExist().create();
        schema.propertyKey("costDistance")
                .asInt()
                .ifNotExist().create();
        schema.propertyKey("costTime")
                .asInt()
                .ifNotExist().create();
        schema.propertyKey("fee")
                .asInt()
                .ifNotExist().create();
        schema.propertyKey("inspect")
                .asText()
                .ifNotExist().create();
        schema.propertyKey("year")
                .asInt()
                .ifNotExist().create();
        schema.propertyKey("month")
                .asInt()
                .ifNotExist().create();
        log.info("Graph Database {} - Schema Data - Property: initialized", databaseName);

        //创建点类型
        schema.vertexLabel("user")
                .properties("id", "name", "phone")
                .primaryKeys("id", "name", "phone")
                .ifNotExist().create();
        schema.vertexLabel("province")
                .properties("name")
                .primaryKeys("name")
                .ifNotExist().create();
        schema.vertexLabel("city")
                .properties("name")
                .primaryKeys("name")
                .ifNotExist().create();
        schema.vertexLabel("station")
                .properties("name", "level", "cargoType")
                .primaryKeys("name")
                .ifNotExist().create();
        schema.vertexLabel("order")
                .properties("id", "orderType", "status", "fee",
                        "cargoType", "information", "inspect",
                        "addressFrom", "addressTo",
                        "consigneeName", "consigneePhone",
                        "datetimeStart", "datetimeEnd"
                )
                .primaryKeys("id")
                .nullableKeys("datetimeEnd")
                .ifNotExist().create();
        schema.vertexLabel("archive")
                .properties("year", "month")
                .primaryKeys("year", "month")
                .ifNotExist().create();
        schema.vertexLabel("record")
                .properties("datetime", "name", "recordType")
                .ifNotExist().create();
        log.info("Graph Database {} - Schema Data - Vertex: initialized", databaseName);

        //创建点属性索引
        schema.indexLabel("userById")
                .onV("user")
                .by("id")
                .secondary()
                .ifNotExist().create();
        schema.indexLabel("userByPhone")
                .onV("user")
                .by("phone")
                .secondary()
                .ifNotExist().create();

        log.info("Graph Database {} - Schema Data - Index on Vertex: initialized", databaseName);

        //创建边类型
        schema.edgeLabel("administer")
                .sourceLabel("province")
                .targetLabel("city")
                .ifNotExist().create();
        schema.edgeLabel("adjacentProvince")//双向
                .sourceLabel("province")
                .targetLabel("province")
                .ifNotExist().create();
        schema.edgeLabel("adjacentCity")//双向
                .sourceLabel("city")
                .targetLabel("city")
                .properties("costDistance")
                .ifNotExist().create();
        schema.edgeLabel("have")
                .sourceLabel("province")
                .targetLabel("station")
                .ifNotExist().create();
        schema.edgeLabel("set")
                .sourceLabel("city")
                .targetLabel("station")
                .ifNotExist().create();
        schema.edgeLabel("path")//双向
                .sourceLabel("station")
                .targetLabel("station")
                .properties("pathType", "costDistance", "costTime")
                .ifNotExist().create();
        schema.edgeLabel("place")
                .sourceLabel("user")
                .targetLabel("order")
                .ifNotExist().create();
        schema.edgeLabel("provinceFrom")
                .sourceLabel("order")
                .targetLabel("province")
                .ifNotExist().create();
        schema.edgeLabel("cityFrom")
                .sourceLabel("order")
                .targetLabel("city")
                .ifNotExist().create();
        schema.edgeLabel("provinceTo")
                .sourceLabel("order")
                .targetLabel("province")
                .ifNotExist().create();
        schema.edgeLabel("cityTo")
                .sourceLabel("order")
                .targetLabel("city")
                .ifNotExist().create();
        schema.edgeLabel("nextStation")
                .sourceLabel("order")
                .targetLabel("station")
                .ifNotExist().create();
        schema.edgeLabel("finalStation")
                .sourceLabel("order")
                .targetLabel("station")
                .ifNotExist().create();
        schema.edgeLabel("startRecord")
                .sourceLabel("order")
                .targetLabel("record")
                .ifNotExist().create();
        schema.edgeLabel("nextRecord")
                .sourceLabel("record")
                .targetLabel("record")
                .ifNotExist().create();
        schema.edgeLabel("archive")
                .sourceLabel("archive")
                .targetLabel("order")
                .ifNotExist().create();
        log.info("Graph Database {} - Schema Data - Edge: initialized", databaseName);

        //创建边属性索引
        schema.indexLabel("pathByCostDistance")
                .onE("path")
                .by("costDistance")
                .secondary()
                .ifNotExist().create();
        schema.indexLabel("pathByCostTime")
                .onE("path")
                .by("costTime")
                .secondary()
                .ifNotExist().create();
        log.info("Graph Database {} - Schema Data - Index on Edge: initialized", databaseName);

        log.info("Graph Database {} Schema Data: All initialized", databaseName);
    }

}
