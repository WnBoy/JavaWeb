package xupt.edu.ajax;

import com.google.gson.Gson;
import xupt.edu.cookie.BaseServlet;
import xupt.edu.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-04-02 9:18
 */
public class AjaxServlet extends BaseServlet {

    public void ajaxTest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax请求过来了");
        Person person= new Person(1, "爽");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(person);
        System.out.println(jsonStr);
        resp.getWriter().write(jsonStr);
    }

    public void jqueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AjqueryAjax请求过来了");
        Person person= new Person(1, "爽");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(person);
        System.out.println(jsonStr);
        resp.getWriter().write(jsonStr);
    }

    public void jqueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryGet请求过来了");
        Person person= new Person(1, "爽");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(person);
        System.out.println(jsonStr);
        resp.getWriter().write(jsonStr);
    }
    public void jqueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryPost请求过来了");
        Person person= new Person(1, "爽");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(person);
        System.out.println(jsonStr);
        resp.getWriter().write(jsonStr);
    }
    public void jquerygetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jquerygetJSON请求过来了");
        Person person= new Person(1, "爽");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(person);
        System.out.println(jsonStr);
        resp.getWriter().write(jsonStr);
    }
    public void jquerygetSerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jquerygetSerialize请求过来了");

        System.out.println("用户名:"+req.getParameter("username"));
        System.out.println("密码:"+req.getParameter("password"));

        Person person= new Person(1, "爽");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(person);
        System.out.println(jsonStr);
        resp.getWriter().write(jsonStr);
    }
}
