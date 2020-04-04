package xupt.edu.servlet1;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-03-15 17:37
 */
public class ContextServlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //直接获取servletcontext
        ServletContext servletContext = getServletContext();

        //4、像Map 一样存取数据
        servletContext.setAttribute("age",18);
        servletContext.setAttribute("sex","男");

        Object age = servletContext.getAttribute("age");
        Object sex = servletContext.getAttribute("sex");
        System.out.println("age="+age+" :sex="+sex);

    }
}
