package xupt.edu.servlet1;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-03-15 16:53
 */

public class ContextServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletConfig().getServletContext();

//        1、获取web.xml 中配置的上下文参数context-param
        String address = servletContext.getInitParameter("address");
        String school = servletContext.getInitParameter("school");
        System.out.println("address:"+address+"  school:"+school);


//        2、获取当前的工程路径，格式: /工程路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);//  /JavaBaseWebTest

//        3、获取工程部署后在服务器硬盘上的绝对路径
            /*
             / 表示: 斜杠被服务器解析地址为:http://ip:port/工程名/  映射到IDEA代码的web目录<br/>

            /JavaBaseWebTest
            F:\workspace_idea2018.1.5\out\artifacts\JavaBaseWebTest_war_exploded\
            F:\workspace_idea2018.1.5\out\artifacts\JavaBaseWebTest_war_exploded\css\1.css
            F:\workspace_idea2018.1.5\out\artifacts\JavaBaseWebTest_war_exploded\img\1.jpg
           */
        String realPath1 = servletContext.getRealPath("/");
        System.out.println(realPath1);

        String realPath2 = servletContext.getRealPath("/css/1.css");
        System.out.println(realPath2);

        String realPath3 = servletContext.getRealPath("/img/1.jpg");
        System.out.println(realPath3);

    }
}
