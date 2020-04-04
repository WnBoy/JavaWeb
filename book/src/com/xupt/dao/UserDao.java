package com.xupt.dao;

import com.xupt.pojo.User;

/**
 * @author Wnlife
 * @create 2020-03-16 19:22
 */
public interface UserDao {

    /**
     * 根据用户名查用户
     * @param username
     * @return 如果返回null,说明没有这个用户。反之亦然
     */
    public User queryByUsername(String username);

    /**
     * 根据用户名和密码查用户
     * @param username
     * @param password
     * @return 如果返回null,说明没有这个用户。反之亦然
     */
    public User queryByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int saveUser(User user);

}
