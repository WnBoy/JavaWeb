package xupt.edu.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServletRequestAPI测试
 *
 * @author Wnlife
 * @create 2020-03-15 20:15
 */
public class HttpServletRequestAPI extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. getRequestURI() 获取请求的资源路径
        System.out.println("URI -> "+request.getRequestURI());
//        2. getRequestURL() 获取请求的统一资源定位符（绝对路径）
        System.out.println("URL -> "+request.getRequestURL());
//        3. getRemoteHost() 获取客户端的ip 地址
        System.out.println("IP -> "+request.getRemoteHost());
//        4. getHeader() 获取请求头
        System.out.println("Hreader -> "+request.getHeader("user-agent"));
//        5. getMethod() 获取请求的方式GET 或POST
        System.out.println("method -> "+request.getMethod());
    }
}
