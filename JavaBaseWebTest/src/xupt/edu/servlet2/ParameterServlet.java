package xupt.edu.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Wnlife
 * @create 2020-03-15 20:49
 */
public class ParameterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求体的字符集为UTF-8，从而解决post 请求的中文乱码问题
        request.setCharacterEncoding("UTF-8");
        System.out.println("---post----");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");

        System.out.println("username= "+username+" password= "+password+" bobby="+Arrays.toString(hobbies));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----get----");

        String username = request.getParameter("username");
        //解决get请求乱码
        //1 先以iso8859-1 进行编码
        //2 再以utf-8 进行解码
        username = new String(username.getBytes("iso-8859-1"), "UTF-8");

        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");

        System.out.println("username= "+username+" password= "+password+" bobby="+Arrays.toString(hobbies));

    }
}
