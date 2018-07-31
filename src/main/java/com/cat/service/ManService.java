package com.cat.service;

import com.cat.entity.Man;

/**
 * 刘文博
 * 2018/7/17 15:53
 */
public interface ManService {
    /**
     * 注册
     * * @return
     */
    boolean register(Man man);

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 检查用户名是否存在
     * @param manName
     * @return
     */
    boolean checkManname(String manName);



    boolean fixPassword(Man man);


    boolean addManInfo(Man man);
}
