package xupt.edu.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-03-15 21:47
 */
public class DispatcherServlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("DispatcherServlet2（柜台2）中查看参数（材料）："+username);
        // 查看柜台1 是否有盖章
        Object key = request.getAttribute("key");
        System.out.println("柜台1 是否有章："+key);
        // 处理自己的业务
        System.out.println("DispatcherServlet2 处理自己的业务");
    }
}
