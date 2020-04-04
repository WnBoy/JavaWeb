package com.xupt.test;

import com.xupt.pojo.User;
import com.xupt.service.UserService;
import com.xupt.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Wnlife
 * @create 2020-03-16 20:45
 */
public class UserServiceTest {

    UserService userService=new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"多米","123","456@163.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "多米", "123", "456@163.com")));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("admin")){
            System.out.println("用户名不可用");
        }else {
            System.out.println("用户名可用");
        }
    }
}