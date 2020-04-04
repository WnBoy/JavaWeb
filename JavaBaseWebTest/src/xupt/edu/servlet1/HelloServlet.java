package xupt.edu.servlet1;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-03-15 13:47
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1--构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2--init方法");

//        1、可以获取Servlet 程序的别名servlet-name 的值
        String servletName = servletConfig.getServletName();
        System.out.println("servlet-name:"+servletName);

//        2、获取初始化参数init-param
        String name = servletConfig.getInitParameter("name");
        String age = servletConfig.getInitParameter("age");
        System.out.println("name="+name+"age="+age);

//        3、获取ServletContext 对象
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println("servletContext="+servletContext);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3--service方法执行了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4-- destory方法");
    }
}
