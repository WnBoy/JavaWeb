package xupt.edu.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-03-16 14:00
 */

public class ResponServletTest1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //方式一：
        // 设置服务器字符集为UTF-8
        resp.setCharacterEncoding("UTF-8");
        // 通过响应头，设置浏览器也使用UTF-8 字符集
        resp.setHeader("Content-Type", "text/html; charset=UTF-8");

        //第二种方式，要求必须放在响应流的前面
        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().write("米米");
    }
}
