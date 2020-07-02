package club.dhbxs.dao.impl;

import club.dhbxs.beans.Root;
import club.dhbxs.dao.RootDao;

/**
 * @author ：1723
 * @date ：Created in 2020/6/27 下午 4:25
 * @description：
 * @version: 1.0
 */
public class RootDaoImpl extends BaseDao implements RootDao {
    /**
     * 添加管理员账户
     *
     * @param root
     * @return
     */
    @Override
    public int addRootUser(Root root) {
        return 0;
    }

    /**
     * 更新管理员账户信息
     *
     * @param root
     * @return
     */
    @Override
    public int updateRootUser(Root root) {
        String sql = "UPDATE root SET rName=?,rPassword=?,rEmail=? WHERE rId = ?;";
        return update(sql,root.getrName(),root.getrPassword(),root.getrEmail(),root.getrId());
    }

    /**
     * 删除管理员用户
     *
     * @param rId
     * @return
     */
    @Override
    public int deleteRootUserByrId(Integer rId) {
        return 0;
    }

    /**
     * 根据管理员用户名查找用户信息
     *
     * @param rName 管理员用户名
     * @return 管理员root对象
     */
    @Override
    public Root queryRootByrName(String rName) {
        String sql = "SELECT * FROM `root` WHERE rName = ?;";
        return queryForOne(Root.class,sql,rName);
    }

    /**
     * 根据管理员ID查找管理员用户信息
     *
     * @param rId
     * @return
     */
    @Override
    public Root queryRootByrId(Integer rId) {
        String sql = "SELECT * FROM `root` WHERE rId = ?;";
        return queryForOne(Root.class,sql,rId);
    }
}
