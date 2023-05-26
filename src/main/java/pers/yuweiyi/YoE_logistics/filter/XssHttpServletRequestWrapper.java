package pers.yuweiyi.YoE_logistics.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: XssHttpServletRequestWrapper <br/>
 * description: 放XSS注入装饰器。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/26/2023 10:35 AM <br/>
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getHeader(String name){
        return super.getHeader(name);
    }

    @Override
    public String getParameter(String name){
        String value = super.getParameter(name);
        return xssEncode(value);
    }

    public static String xssEncode(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        str = str.replaceAll(";", "&#59;");
        str = str.replaceAll("<", "&#60;").replaceAll(">", "&#62;");
        str = str.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        str = str.replaceAll("\\$", "&#36;");
        str = str.replaceAll("%", "&#37;");
        str = str.replaceAll("\\/", "&#47;").replaceAll("\\\\", "&#92;");
        str = str.replaceAll(":", "&#58;");
        str = str.replaceAll("\\?", "&#63;").replaceAll("@", "&#64;");
        str = str.replaceAll("\\^", "&#94;");

//        str = str.replaceAll("'", "&#39;").replaceAll("\"", "&#34;");
        str = str.replaceAll("'", " ").replaceAll("\"", " ");

        return str;
    }
}
