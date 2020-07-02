package club.dhbxs.dao;

import club.dhbxs.beans.Root;

/**
 * @author 17235
 */
public interface RootDao {

    /**
     * 添加管理员账户
     *
     * @param root
     * @return
     */
    int addRootUser(Root root);

    /**
     * 更新管理员账户信息
     *
     * @param root
     * @return
     */
    int updateRootUser(Root root);

    /**
     * 删除管理员用户
     *
     * @param rId
     * @return
     */
    int deleteRootUserByrId(Integer rId);

    /**
     * 根据管理员用户名查找用户信息
     *
     * @param rName
     * @return
     */
    Root queryRootByrName(String rName);

    /**
     * 根据管理员ID查找管理员用户信息
     *
     * @param rId
     * @return
     */
    Root queryRootByrId(Integer rId);
}
