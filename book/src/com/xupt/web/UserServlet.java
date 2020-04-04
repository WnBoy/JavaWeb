package com.xupt.web;

import com.google.gson.Gson;
import com.xupt.pojo.User;
import com.xupt.service.UserService;
import com.xupt.service.impl.UserServiceImpl;
import com.xupt.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author Wnlife
 * @create 2020-03-20 16:19
 */
public class UserServlet extends BaseServlet {

    UserService userService=new UserServiceImpl();

    /**
     * 处理登录的函数
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = WebUtils.copyParameter(request.getParameterMap(), new User());
        User loginUser = userService.login(user);
        if(loginUser==null){//登录失败
            //将错误信息放置到域对象中
            request.setAttribute("msg","用户名或密码错误");
            request.setAttribute("username",user.getUsername());

            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);

        }else {//登录成功
            //将用户信息放置到session域中
            request.getSession().setAttribute("user",loginUser);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
    }

    /**
     * 处理注册的函数
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取谷歌生成的验证码
        String token= (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除验证码
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //1.接受参数
        User user = WebUtils.copyParameter(request.getParameterMap(), new User());
        String code = request.getParameter("code");

        //如果验证码正确
        if(token!=null&&token.equalsIgnoreCase(code)){
            if (userService.existsUsername(user.getUsername())) {//用户名已占用，跳转到注册页面
                System.out.println("用户名存在");
                //将错误信息放置到request域对象里面
                request.setAttribute("msg","用户名存在");
                request.setAttribute("username",user.getUsername());
                request.setAttribute("email",user.getEmail());
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }else {//用户名可用，跳转到注册成功页面
                userService.registUser(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }

        }else {//验证按错误 ,跳转到注册页面
            System.out.println("验证码错误");
            //将错误信息放置到request域对象里面
            request.setAttribute("msg","验证码错误");
            request.setAttribute("username",user.getUsername());
            request.setAttribute("email",user.getEmail());
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }
    }

    /**
     * 注销登录的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getSession().invalidate();
       //请求转发到首页
       response.sendRedirect(request.getContextPath());
    }

    /**
     * Ajax验证用户名
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxTestUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean b = userService.existsUsername(username);
        Map<String,Object>map=new HashMap<>();
        map.put("msg",b);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        response.getWriter().write(json);
    }
}
