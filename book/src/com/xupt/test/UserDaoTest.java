package com.xupt.test;

import com.xupt.dao.UserDao;
import com.xupt.dao.impl.UserDaoImpl;
import com.xupt.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Wnlife
 * @create 2020-03-16 19:54
 */
public class UserDaoTest {

    UserDao userDao=new UserDaoImpl();
    @Test
    public void queryByUsername() {
        if(userDao.queryByUsername("admin")==null){
            System.out.println("用户名可用");
        }else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryByUsernameAndPassword() {
        if(userDao.queryByUsernameAndPassword("admin","admin")==null){
            System.out.println("用户名和密码错误");
        }else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"mimi","123","mimi@163.com")));
    }
}