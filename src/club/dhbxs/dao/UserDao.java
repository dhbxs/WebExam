package club.dhbxs.dao;

import club.dhbxs.beans.User;

/**
 * @author 17235
 */
public interface UserDao {

    /**
     * 注册新用户
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据用户ID删除用户信息
     *
     * @param uId
     * @return
     */
    int deleteUserByrId(Integer uId);

    /**
     * 根据用户名查找用户信息
     *
     * @param uName
     * @return
     */
    User queryUserByuName(String uName);

    /**
     * 根据用户ID查找用户信息
     *
     * @param uId
     * @return
     */
    User queryUserByuId(Integer uId);
}
