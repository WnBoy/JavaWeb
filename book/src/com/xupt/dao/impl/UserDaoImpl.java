package com.xupt.dao.impl;

import com.xupt.dao.UserDao;
import com.xupt.pojo.User;

/**
 * @author Wnlife
 * @create 2020-03-16 19:37
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryByUsername(String username) {
        String sql="select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        String sql="select `id`,`username`,`password`,`email` from t_user where username= ? and password= ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
