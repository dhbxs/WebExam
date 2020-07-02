package club.dhbxs.service.impl;

import club.dhbxs.beans.Root;
import club.dhbxs.dao.RootDao;
import club.dhbxs.dao.impl.RootDaoImpl;
import club.dhbxs.service.UpdateRoot;

/**
 * @ClassName UpdateRoot
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/7/2 17:59
 * @Version 1.0
 **/
public class UpdateRootImpl implements UpdateRoot {
    /**
     * 修改管理员用户信息及密码
     *
     * @param root
     */
    @Override
    public void updateRoot(Root root) {
        RootDao rootDao = new RootDaoImpl();
        rootDao.updateRootUser(root);
    }
}
