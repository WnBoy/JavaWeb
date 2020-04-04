package xupt.edu.TestJSP;

import xupt.edu.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wnlife
 * @create 2020-03-18 11:58
 */
public class TestJspServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Student>list=new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            int t = i + 1;
            list.add(new Student(t,"name"+t, 18+t,"phone"+t));
        }
        //将数据放置到request域中
        request.setAttribute("list",list);
        //请求转发
        request.getRequestDispatcher("/jsp/stu.jsp").forward(request,response);
    }
}
