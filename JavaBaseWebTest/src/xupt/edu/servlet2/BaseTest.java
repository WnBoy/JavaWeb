package xupt.edu.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-03-16 13:00
 */
public class BaseTest extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet转发");
        request.getRequestDispatcher("/a/b/c.html").forward(request,response);
    }
}
