package club.dhbxs.dao.impl;

import club.dhbxs.beans.User;
import club.dhbxs.dao.UserDao;

/**
 * @author ：1723
 * @date ：Created in 2020/6/27 下午 4:25
 * @description：
 * @version: 1.0
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    /**
     * 注册新用户
     *
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        String sql = "INSERT INTO `user`(uId,uName,uPassword,uEmail) VALUES (?,?,?,?);";
        return update(sql, user.getuId(), user.getuName(), user.getuPassword(), user.getuEmail());
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        String sql = "UPDATE `user` SET uName=?,uPassword=?,uEmail=? WHERE uId = ?;";
        return update(sql, user.getuName(), user.getuPassword(), user.getuEmail(), user.getuId());
    }

    /**
     * 根据用户ID删除用户信息
     *
     * @param uId
     * @return
     */
    @Override
    public int deleteUserByrId(Integer uId) {
        String sql = "DELETE FROM `user` WHERE uId = ?;";
        return update(sql, uId);
    }

    /**
     * 根据用户名查找用户信息
     *
     * @param uName
     * @return
     */
    @Override
    public User queryUserByuName(String uName) {
        String sql = "SELECT * FROM `user` WHERE uName = ?;";
        User user = queryForOne(User.class, sql, uName);
        return user;
    }

    /**
     * 根据用户ID查找用户信息
     *
     * @param uId
     * @return
     */
    @Override
    public User queryUserByuId(Integer uId) {
        String sql = "SELECT * FROM `user` WHERE uId = ?;";
        User user = queryForOne(User.class, sql, uId);
        return user;
    }
}
