package xupt.edu.Kaptcha;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author Wnlife
 * @create 2020-03-28 14:36
 */
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取谷歌生成的验证码
        String token= (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除验证码
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //表单数据
        String code = request.getParameter("code");
        String username = request.getParameter("username");
        if(token!=null&&token.equalsIgnoreCase(code)){
            System.out.println("注册成功，数据保存到数据库");
            response.sendRedirect(request.getContextPath()+"/ok.jsp");
        }else {
            System.out.println("验证按错误");
        }
    }

}
