package club.dhbxs.service;

/**
 * @ClassName SignUp
 * @Author 17235
 * @Description 用户注册业务逻辑
 * @Date Created in 2020/6/30 上午 8:14
 * @Version 1.0
 **/
public interface SignUp {
    /**
     * 用户注册
     *
     * @param name     用户名
     * @param password 用户密码
     * @param email    用户邮箱地址
     */
    void signUp(String name, String password, String email);


}
