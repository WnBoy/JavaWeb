package com.xupt.service;

import com.xupt.pojo.User;

/**
 * @author Wnlife
 * @create 2020-03-16 20:31
 */
public interface UserService {

    /**
     * 用户注册
     */
    public void registUser(User user);

    /**
     * 用户登录
     * @param user
     * @return 如果返回null，说明登录失败，返回有值，是登录成功
     */
    public User login(User user);

    /**
     * 检查 用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);
}
