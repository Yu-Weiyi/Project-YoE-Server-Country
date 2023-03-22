package pers.yuweiyi.YoE_logistics.dao.vertex;

import org.apache.hugegraph.structure.graph.Vertex;
import pers.yuweiyi.YoE_logistics.pojo.po.vertex.UserPO;

import java.util.Set;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: UserDAO <br/>
 * description: 数据库中对User点操作接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 1/26/2023 1:48 PM <br/>
 */
public interface UserDAO {
    Vertex insert(UserPO userPO);

    Set<Vertex> selectById(String id);

    Set<Vertex> selectByPhone(String phone);
}
