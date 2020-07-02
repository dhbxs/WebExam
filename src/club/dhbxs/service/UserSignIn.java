package club.dhbxs.service;

import club.dhbxs.beans.User;

/**
 * @ClassName UserSignIn
 * @Author 17235
 * @Description 处理用户登录的service服务
 * @Date Created in 2020/6/29 下午 11:28
 * @Version 1.0
 **/
public interface UserSignIn {
    /**
     * 传入用户名密码查询是否在数据库中有，如果有，则返回User对象
     *
     * @param uName 用户名
     * @param uPassword 用户密码
     * @return User对象
     */
    User userVerify(String uName, String uPassword);
}
