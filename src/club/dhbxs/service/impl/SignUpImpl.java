package club.dhbxs.service.impl;

import club.dhbxs.beans.User;
import club.dhbxs.dao.UserDao;
import club.dhbxs.dao.impl.UserDaoImpl;
import club.dhbxs.service.SignUp;

/**
 * @ClassName SignUp
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/6/30 上午 8:17
 * @Version 1.0
 **/
public class SignUpImpl implements SignUp {
    /**
     * 用户注册
     *
     * @param name     用户名
     * @param password 用户密码
     * @param email    用户邮箱地址
     */
    @Override
    public void signUp(String name, String password, String email) {
        User user = new User(null,name,password,email);
        UserDao userDao = new UserDaoImpl();
        userDao.addUser(user);
    }
}
