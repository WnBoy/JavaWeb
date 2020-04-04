package com.xupt.service.impl;

import com.xupt.dao.UserDao;
import com.xupt.dao.impl.UserDaoImpl;
import com.xupt.pojo.User;
import com.xupt.service.UserService;

/**
 * @author Wnlife
 * @create 2020-03-16 20:35
 */
public class UserServiceImpl implements UserService {

    UserDao userDao=new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryByUsername(username)==null){
            return false;
        }
        return true;
    }
}
