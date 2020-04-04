package com.xupt.web;

import com.xupt.pojo.User;
import com.xupt.service.UserService;
import com.xupt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-03-16 21:36
 * 已经删了
 */
public class RegisterServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        //如果验证码正确
        if("abcde".equalsIgnoreCase(code)){
            if (userService.existsUsername(username)) {//用户名已占用，跳转到注册页面
                System.out.println("用户名存在");
                //将错误信息放置到request域对象里面
                request.setAttribute("msg","用户名存在");
                request.setAttribute("username",username);
                request.setAttribute("email",email);
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }else {//用户名可用，跳转到注册成功页面
                userService.registUser(new User(null,username,password,email));
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }

        }else {//验证按错误 ,跳转到注册页面
            System.out.println("验证码错误");
            //将错误信息放置到request域对象里面
            request.setAttribute("msg","验证码错误");
            request.setAttribute("username",username);
            request.setAttribute("email",email);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }
    }
}
