package pers.yuweiyi.YoE_logistics.service.impl;

import org.apache.hugegraph.structure.graph.Edge;
import org.apache.hugegraph.structure.graph.Vertex;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pers.yuweiyi.YoE_logistics.dao.edge.PathDAO;
import pers.yuweiyi.YoE_logistics.dao.edge.impl.PathDAOImpl;
import pers.yuweiyi.YoE_logistics.dao.vertex.StationDAO;
import pers.yuweiyi.YoE_logistics.dao.vertex.impl.StationDAOImpl;
import pers.yuweiyi.YoE_logistics.service.BackendManageService;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: BackendManageServiceImpl <br/>
 * description: 后台管理服务实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/25/2023 11:44 PM <br/>
 */
@Service
public class BackendManageServiceImpl implements BackendManageService {

    @Override
    public void updatePathWeight(String stationFromName, String stationToName, int newWeight) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        StationDAO stationDAO = (StationDAOImpl) context.getBean("stationDAOImpl");
        Vertex stationFromVertex = stationDAO.selectByName(stationFromName);
        Vertex stationToVertex = stationDAO.selectByName(stationToName);

        PathDAO pathDAO = (PathDAOImpl) context.getBean("pathDAOImpl");
        Edge pathEdge = pathDAO.select(stationFromVertex, stationToVertex);

        pathEdge.property("costDistance", newWeight);
    }
}
