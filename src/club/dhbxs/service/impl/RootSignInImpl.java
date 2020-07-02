package club.dhbxs.service.impl;

import club.dhbxs.beans.Root;
import club.dhbxs.dao.RootDao;
import club.dhbxs.dao.impl.RootDaoImpl;
import club.dhbxs.service.RootSignIn;

/**
 * @ClassName RootSignInImpl
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/6/30 下午 6:08
 * @Version 1.0
 **/
public class RootSignInImpl implements RootSignIn {
    private final RootDao rootDao = new RootDaoImpl();
    /**
     * 管理员登录验证
     *
     * @param rName    管理员账户名
     * @param password 管理员密码
     * @return 管理员实体对象
     */
    @Override
    public Root rootSignIn(String rName, String password) {
        Root root = rootDao.queryRootByrName(rName);
        if (root != null){
            if (root.getrPassword().equals(password)){
                return root;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
}
