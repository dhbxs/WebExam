package club.dhbxs.dao;

import club.dhbxs.beans.Book;
import club.dhbxs.beans.Borrow;

import java.util.List;

/**
 * @author 17235
 */
public interface BorrowDao {

    /**
     * 向borrow表里添加数据，即添加用户借书信息
     * @param borrow 借阅对象
     */
    int addBorrow(Borrow borrow);

    /**
     * 更新读者借阅信息
     * @param borrow 借阅对象
     * @return 返回执行结果
     */
    int updateBorrow(Borrow borrow);

    /**
     * 根据用户ID查找到用户当前所有的借阅信息
     * @param uId 用户id
     * @return 返回List集合
     */
    List<Borrow> queryBorrowByUid(Integer uId);

    /**
     * 查找当前书籍当前用户的借阅信息
     * @param uId 用户id
     * @param  bId 书id
     * @return 返回查找结果Borrow对象
     */
    Borrow queryBorrowByUidBid(Integer uId,Integer bId);

    /**
     * 通过borrowid查找借阅信息
     * @param borrowId
     * @return
     */
    Borrow queryBorrowByBorrowId(Integer borrowId);
}
