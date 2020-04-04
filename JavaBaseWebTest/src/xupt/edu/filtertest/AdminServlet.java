package xupt.edu.filtertest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-04-01 10:12
 */
public class AdminServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("admin".equals(username)&&"admin".equals(password)){
            request.getSession().setAttribute("user",username);
            response.getWriter().write("登录成功");
        }else {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
