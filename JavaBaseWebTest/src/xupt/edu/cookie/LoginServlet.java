package xupt.edu.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-03-27 22:32
 */
public class LoginServlet extends BaseServlet {
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //登录成功,将用户名放置到cookie中
        if("wnlife".equals(username)&&"123".equals(password)){
            System.out.println("登录成功");
            Cookie usernameCookie = new Cookie("username", username);
            usernameCookie.setMaxAge(60*60*24*7);
            response.addCookie(usernameCookie);
        }else {//登录失败
            System.out.println("登录失败");
        }
    }
}
