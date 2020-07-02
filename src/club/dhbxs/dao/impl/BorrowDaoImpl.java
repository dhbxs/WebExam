package club.dhbxs.dao.impl;

import club.dhbxs.beans.Borrow;
import club.dhbxs.dao.BorrowDao;

import java.util.List;

/**
 * @author ：1723
 * @date ：Created in 2020/6/27 下午 4:25
 * @description：
 * @version: 1.0
 */
public class BorrowDaoImpl extends BaseDao implements BorrowDao {
    /**
     * 向borrow表里添加数据，即添加用户借书信息
     *
     * @param borrow borrow实体对象
     */
    @Override
    public int addBorrow(Borrow borrow) {
        String sql = "INSERT INTO borrow (borrowId,uId,bId,bName,bAuthor,bBdate,bRdate,bState) VALUES (?,?,?,?,?,?,?,?);";
        return update(sql,borrow.getBorrowId(),borrow.getuId(),borrow.getbId(),borrow.getbName(),borrow.getbAuthor(),borrow.getbBdate(),borrow.getbRdate(),borrow.getbState());
    }

    /**
     * 更新读者借阅信息
     *
     * @param borrow borrow实体对象
     * @return 更新状态
     */
    @Override
    public int updateBorrow(Borrow borrow) {
        String sql = "UPDATE borrow SET uId=?,bId=?,bName=?,bAuthor=?,bBdate=?,bRdate=?,bState=? WHERE borrowId = ?;";
        return update(sql,borrow.getuId(),borrow.getbId(),borrow.getbName(),borrow.getbAuthor(),borrow.getbBdate(),borrow.getbRdate(),borrow.getbState(),borrow.getBorrowId());
    }

    /**
     * 根据用户ID查找到用户当前的借阅信息
     *
     * @param uId 用户id
     * @return borrow对象
     */
    @Override
    public List<Borrow> queryBorrowByUid(Integer uId) {
        String sql = "SELECT * FROM `borrow` WHERE uId = ?;";
        return queryForList(Borrow.class,sql, uId);
    }

    /**
     * 查找当前书籍当前用户的借阅信息
     *
     * @param uId 用户id
     * @param bId 书id
     * @return 返回查找结果Book对象
     */
    @Override
    public Borrow queryBorrowByUidBid(Integer uId, Integer bId) {
        String sql = "SELECT * FROM `borrow` WHERE uId = ? and bId = ?;";
        return queryForOne(Borrow.class,sql,uId,bId);
    }

    /**
     * 通过borrowid查找借阅信息
     *
     * @param borrowId 借阅id
     * @return 借阅信息
     */
    @Override
    public Borrow queryBorrowByBorrowId(Integer borrowId) {
        String sql = "SELECT * FROM `borrow` WHERE borrowId = ?;";
        return queryForOne(Borrow.class,sql,borrowId);
    }
}
