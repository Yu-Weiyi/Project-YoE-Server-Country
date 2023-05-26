package pers.yuweiyi.YoE_logistics.filter;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: GremlinFilter <br/>
 * description: 防Gremlin语句注入过滤器。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/26/2023 11:40 AM <br/>
 */
public class GremlinFilter {
    public String doFilter(String str){
        str = str.replaceAll("'", " ’ ").replaceAll("\"", " “ ");
        return str;
    }
}
