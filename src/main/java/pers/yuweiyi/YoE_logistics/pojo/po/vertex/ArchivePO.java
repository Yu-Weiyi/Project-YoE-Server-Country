package pers.yuweiyi.YoE_logistics.pojo.po.vertex;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.hugegraph.structure.graph.Vertex;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: ArchiveEntity <br/>
 * description: 归档点数据项。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 2/2/2023 11:33 PM <br/>
 */
@Data
@AllArgsConstructor
public class ArchivePO {
    @NotNull private int year;//年
    @NotNull private int month;//月

    public ArchivePO(@NotNull Vertex vertex){
        this.year = (int) vertex.property("year");
        this.month = (int) vertex.property("month");
    }

    public static @NotNull Set<ArchivePO> VertexSetToArchiveEntity(@NotNull Set<Vertex> vertexSet){
        Set<ArchivePO> archivePOSet = new HashSet<ArchivePO>();
        Iterator<Vertex> vertexIterator = vertexSet.iterator();
        vertexIterator.forEachRemaining((vertex) -> {
            ArchivePO archivePO = new ArchivePO(vertex);
            archivePOSet.add(archivePO);
        });
        return archivePOSet;
    }
}
