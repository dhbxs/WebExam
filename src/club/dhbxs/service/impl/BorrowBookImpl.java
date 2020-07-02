package club.dhbxs.service.impl;

import club.dhbxs.beans.Book;
import club.dhbxs.beans.Borrow;
import club.dhbxs.beans.User;
import club.dhbxs.dao.BookDao;
import club.dhbxs.dao.BorrowDao;
import club.dhbxs.dao.impl.BookDaoImpl;
import club.dhbxs.dao.impl.BorrowDaoImpl;
import club.dhbxs.service.BorrowBook;

import java.sql.Timestamp;

/**
 * @ClassName BorrowBookImpl
 * @Author 17235
 * @Description 借书业务逻辑
 * @Date Created in 2020/6/30 下午 1:35
 * @Version 1.0
 **/
public class BorrowBookImpl implements BorrowBook {


    private final BookDao bookDao = new BookDaoImpl();
    private final BorrowDao borrowDao = new BorrowDaoImpl();
    /**
     * 借书逻辑的具体实现
     *
     * @param bId  图书id
     * @param user 用户信息
     */
    @Override
    public void borrowBook(Integer bId, User user) {
        Book book = bookDao.queryBookById(bId);
        Borrow borrow = new Borrow(null, user.getuId(), bId, book.getbName(), book.getbAuthor(), new Timestamp(System.currentTimeMillis()), null, "借阅中");
        borrowDao.addBorrow(borrow);

        //更新馆藏图书信息
        book.setbNumber(book.getbNumber() - 1);
        book.setbBorrow(book.getbBorrow() + 1);
        bookDao.updateBook(book);
    }

    /**
     * 归还书籍
     *
     * @param borrowId  图书ID
     * @param user 用户信息
     */
    @Override
    public void returnBook(Integer borrowId, User user) {
        Borrow borrow = borrowDao.queryBorrowByBorrowId(borrowId);
        Book book = bookDao.queryBookById(borrow.getbId());
        //更新馆藏图书信息
        book.setbNumber(book.getbNumber() + 1);
        book.setbBorrow(book.getbBorrow() - 1);
        bookDao.updateBook(book);

        //处理borrow表
        borrow.setbRdate(new Timestamp(System.currentTimeMillis()));
        borrow.setbState("已还");
        borrowDao.updateBorrow(borrow);
    }

    /**
     * 续借书籍
     *
     * @param borrowId 借书id
     */
    @Override
    public void redecorateBook(Integer borrowId) {
        Borrow borrow = borrowDao.queryBorrowByBorrowId(borrowId);
        //处理borrow表
        borrow.setbBdate(new Timestamp(System.currentTimeMillis()));
        borrow.setbState("续借中");
        borrowDao.updateBorrow(borrow);
    }
}
