package xupt.edu.servlet2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-03-15 21:40
 */
public class DispatcherServlet1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("DispatcherServlet1（柜台1）中查看参数（材料）："+username);
        // 给材料盖一个章，并传递到DispatcherServlet2（柜台2）去查看
        request.setAttribute("key","多米");
        // 问路：Servlet2（柜台2）怎么走
        /**
         * 请求转发必须要以斜杠打头，/ 斜杠表示地址为：http://ip:port/工程名/ , 映射到IDEA 代码的web 目录<br/>
         */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/dispatcherServlet2");
        // 走向DispatcherServlet2（柜台2）
        requestDispatcher.forward(request,response);
    }
}
