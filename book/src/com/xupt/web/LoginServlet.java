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
 * @create 2020-03-17 9:31
 * 已经删了
 */
public class LoginServlet extends HttpServlet {

    UserService userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User login = userService.login(new User(null, username, password, null));
        if(login==null){//登录失败
            //将错误信息放置到域对象中
            request.setAttribute("msg","用户名或密码错误");
            request.setAttribute("username",username);

            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);

        }else {//登录成功
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
    }
}
