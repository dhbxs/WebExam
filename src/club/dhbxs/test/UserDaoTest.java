package club.dhbxs.test;

import club.dhbxs.beans.User;
import club.dhbxs.dao.UserDao;
import club.dhbxs.dao.impl.UserDaoImpl;
import org.junit.Test;

/**
 * @author 17235
 */
public class UserDaoTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void addUser() {
        User user = new User(null,"005","000","1@qq.com");
        userDao.addUser(user);
    }

    @Test
    public void updateUser() {
        User user = new User(5,"010","000","1@qq.com");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUserByrId() {
        userDao.deleteUserByrId(5);
    }

    @Test
    public void queryUserByuName() {
        User user = userDao.queryUserByuName("001");
        System.out.println(user);
    }

    @Test
    public void queryUserByuId() {
        User user = userDao.queryUserByuId(1);
        System.out.println(user);
    }
}