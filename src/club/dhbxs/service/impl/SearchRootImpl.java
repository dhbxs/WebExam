package club.dhbxs.service.impl;

import club.dhbxs.beans.Root;
import club.dhbxs.dao.RootDao;
import club.dhbxs.dao.impl.RootDaoImpl;
import club.dhbxs.service.SearchRoot;

/**
 * @ClassName SearchRootImpl
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/7/2 16:00
 * @Version 1.0
 **/
public class SearchRootImpl implements SearchRoot {
    /**
     * 根据root用户的ID查找root用户Id信息
     *
     * @param Id root用户id
     * @return 返回root用户对象
     */
    @Override
    public Root searchRoot(Integer Id) {
        RootDao rootDao = new RootDaoImpl();
        return rootDao.queryRootByrId(Id);
    }
}
