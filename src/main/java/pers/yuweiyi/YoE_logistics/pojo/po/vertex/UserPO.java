package pers.yuweiyi.YoE_logistics.pojo.po.vertex;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.hugegraph.structure.graph.Vertex;
import org.jetbrains.annotations.NotNull;
import pers.yuweiyi.YoE_logistics.pojo.dto.OrderDTO;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: UserEntity <br/>
 * description: 用户点数据项。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 1/26/2023 12:35 PM <br/>
 */
@Data
@AllArgsConstructor
public class UserPO {
    @NotNull private String id;//身份证ID
    @NotNull private String name;//昵称
    @NotNull private String phone;//手机号码

    public UserPO(@NotNull Vertex vertex){
        this.id = (String) vertex.property("id");
        this.name = (String) vertex.property("name");
        this.phone = (String) vertex.property("phone");
    }

    public UserPO(@NotNull OrderDTO orderDTO){
        this.id = orderDTO.getConsigner_id();
        this.name = orderDTO.getConsigner_name();
        this.phone = orderDTO.getConsigner_phone();
    }

    public static @NotNull Set<UserPO> VertexSetToUserEntitySet(@NotNull Set<Vertex> vertexSet){
        Set<UserPO> userPOSet = new HashSet<UserPO>();
        Iterator<Vertex> vertexIterator = vertexSet.iterator();
        vertexIterator.forEachRemaining((vertex) -> {
            UserPO userPO = new UserPO(vertex);
            userPOSet.add(userPO);
        });
        return userPOSet;
    }
}
