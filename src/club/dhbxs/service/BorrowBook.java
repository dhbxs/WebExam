package club.dhbxs.service;

import club.dhbxs.beans.User;

/**
 * @ClassName BorrowBook
 * @Author 17235
 * @Description 借书业务逻辑接口
 * @Date Created in 2020/6/30 下午 1:32
 * @Version 1.0
 **/
public interface BorrowBook {
    /**
     * 借书逻辑
     *
     * @param bId  图书id
     * @param user 用户信息
     */
    void borrowBook(Integer bId, User user);

    /**
     * 归还书籍
     *
     * @param borrowId 图书ID
     * @param user     用户信息
     */
    void returnBook(Integer borrowId, User user);

    /**
     * 续借书籍
     *
     * @param borrowId 借书id
     */
    void redecorateBook(Integer borrowId);
}
