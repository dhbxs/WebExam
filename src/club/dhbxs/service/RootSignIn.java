package club.dhbxs.service;

import club.dhbxs.beans.Root;

/**
 * @ClassName RootSignIn
 * @Author 17235
 * @Description 管理员登录验证业务逻辑
 * @Date Created in 2020/6/30 下午 5:50
 * @Version 1.0
 **/
public interface RootSignIn {
    /**
     * 管理员登录验证
     * @param rName 管理员账户名
     * @param password 管理员密码
     * @return 管理员实体对象
     */
    Root rootSignIn(String rName,String password);
}
