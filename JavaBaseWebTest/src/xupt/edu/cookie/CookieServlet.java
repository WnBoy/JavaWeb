package xupt.edu.cookie;

import xupt.edu.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-03-27 20:10
 */
public class CookieServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 创建Cookie 对象
        Cookie cookie1 = new Cookie("key1", "val1");
        //2 通知客户端保存Cookie
        response.addCookie(cookie1);
        Cookie cookie2 = new Cookie("key2", "val2");
        response.addCookie(cookie2);
        response.getWriter().write("cookie创建好了");
    }

    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            // getName 方法返回Cookie 的key（名）
            // getValue 方法返回Cookie 的value 值
            response.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
        }
        Cookie iwantcookie = CookieUtils.findCookie("key1", request.getCookies());
        if (iwantcookie != null) {
            response.getWriter().write(iwantcookie.getName() + "::" + iwantcookie.getValue());
        }
    }

    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //方案一：
        //1、先创建一个要修改的同名（指的就是key）的Cookie 对象
        //2、在构造器，同时赋于新的Cookie 值。
        Cookie cookie1 = new Cookie("key1", "newVal1");
        //3、调用response.addCookie( Cookie );
        response.addCookie(cookie1);
        response.getWriter().write("cookie已经修改了");



        //方案二：
        //1、先查找到需要修改的Cookie 对象
        Cookie cookie2 = CookieUtils.findCookie("key2", request.getCookies());
        if (cookie2 != null) {
            //2、调用setValue()方法赋于新的Cookie 值。
            cookie2.setValue("newVal2");
            //3、调用response.addCookie()通知客户端保存修改
            response.addCookie(cookie2);
        }

    }
}
