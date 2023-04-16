package pers.yuweiyi.YoE_logistics.util;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.hugegraph.driver.GraphManager;
import org.apache.hugegraph.driver.GremlinManager;
import org.apache.hugegraph.driver.HugeClient;
import org.apache.hugegraph.driver.SchemaManager;
import org.apache.hugegraph.structure.graph.Edge;
import org.apache.hugegraph.structure.graph.Path;
import org.apache.hugegraph.structure.graph.Vertex;
import org.apache.hugegraph.structure.gremlin.Result;
import org.apache.hugegraph.structure.gremlin.ResultSet;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import pers.yuweiyi.YoE_logistics.init.GraphDatabaseGraphDataInitializer;
import pers.yuweiyi.YoE_logistics.init.GraphDatabasePreviousDataCleaner;
import pers.yuweiyi.YoE_logistics.init.GraphDatabaseSchemaDataInitializer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: GraphDatabaseUtil <br/>
 * description: 图数据库操作工具。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 1/26/2023 11:33 AM <br/>
 */
//@Slf4j
public class GraphDatabaseUtil {
    public static String databaseUrl = "http://172.23.90.124:8080";
    public static String databaseName = "hugegraph";
    static HugeClient hugeClient;
    public static SchemaManager schemaManager;
    public static GraphManager graphManager;
    public static GremlinManager gremlinManager;

    static {
        HugeClient client = HugeClient.builder(databaseUrl, databaseName).build();
//        log.info("Graph Database {}: Connected", databaseName);
        hugeClient = client;
//        log.info("Graph Database {} - HugeClient: Open", databaseName);

        SchemaManager schema = hugeClient.schema();
        schemaManager = schema;
//        log.info("Graph Database {} - SchemaManager: Open", databaseName);

        GraphManager graph = hugeClient.graph();
        graphManager = graph;
//        log.info("Graph Database {} - GraphManager: Open", databaseName);

        GremlinManager gremlin = hugeClient.gremlin();
        gremlinManager = gremlin;
//        log.info("Graph Database {} - GremlinManager: Open", databaseName);
    }

    public static void initializeData(){
        GraphDatabaseSchemaDataInitializer graphDatabaseSchemaDataInitializer = new GraphDatabaseSchemaDataInitializer();
        graphDatabaseSchemaDataInitializer.initializeSchemaData();
        GraphDatabasePreviousDataCleaner graphDatabasePreviousDataCleaner = new GraphDatabasePreviousDataCleaner();
        graphDatabasePreviousDataCleaner.cleanPreviousData();
        GraphDatabaseGraphDataInitializer graphDatabaseGraphDataInitializer = new GraphDatabaseGraphDataInitializer();
        graphDatabaseGraphDataInitializer.initializeGraphData();
    }

    public static @NotNull Set<Vertex> changeResultSetToVertexSet(@NotNull ResultSet resultSet){
        Set<Vertex> vertexSet = new HashSet<Vertex>();
        Iterator<Result> resultIterator = resultSet.iterator();
        resultIterator.forEachRemaining((result) -> {
            Vertex vertex = (Vertex) result.getObject();
            vertexSet.add(vertex);
        });
        return vertexSet;
    }

    public static @NotNull Set<Edge> changeResultSetToEdgeSet(@NotNull ResultSet resultSet){
        Set<Edge> edgeSet = new HashSet<Edge>();
        Iterator<Result> resultIterator = resultSet.iterator();
        resultIterator.forEachRemaining((result) -> {
            Edge edge = (Edge) result.getObject();
            edgeSet.add(edge);
        });
        return edgeSet;
    }

    public static @NotNull Set<Path> changeResultSetToPathSet(@NotNull ResultSet resultSet){
        Set<Path> pathSet = new HashSet<Path>();
        Iterator<Result> resultIterator = resultSet.iterator();
        resultIterator.forEachRemaining((result) -> {
            Path path = (Path) result.getObject();
            pathSet.add(path);
        });
        return pathSet;
    }

    public static Path cutPathFromHead(Path path, int number){
        List<Object> list = path.objects();

        list = list.subList(number, list.size());

        Path newPath = new Path(list);

        return newPath;
    }
}
