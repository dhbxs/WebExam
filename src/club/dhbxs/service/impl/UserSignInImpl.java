package club.dhbxs.service.impl;

import club.dhbxs.beans.User;
import club.dhbxs.dao.UserDao;
import club.dhbxs.dao.impl.UserDaoImpl;
import club.dhbxs.service.UserSignIn;

/**
 * @author ：17235
 * @date ：Created in 2020/6/27 下午 6:29
 * @description：
 * @version: 1.0
 */
public class UserSignInImpl implements UserSignIn {
    private final UserDao userDao = new UserDaoImpl();
    /**
     * 传入用户名密码查询是否在数据库中有，如果有，则返回User对象
     *
     * @param uName 用户名
     * @param uPassword 用户密码
     * @return User对象
     */
    @Override
    public User userVerify(String uName, String uPassword) {
        User user = userDao.queryUserByuName(uName);
        if (user != null){
            if (user.getuPassword().equals(uPassword)){
                return user;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
}
