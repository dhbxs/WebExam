package club.dhbxs.service.impl;

import club.dhbxs.beans.Book;
import club.dhbxs.dao.BookDao;
import club.dhbxs.dao.impl.BookDaoImpl;
import club.dhbxs.service.QueryBooks;

import java.util.List;

/**
 * @ClassName QueryBooksImpl
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/6/30 上午 11:54
 * @Version 1.0
 **/
public class QueryBooksImpl implements QueryBooks {
    private final BookDao bookDao = new BookDaoImpl();
    /**
     * @return
     */
    @Override
    public List<Book> queryAllBooks() {
        return bookDao.queryBooks();
    }

    /**
     * 模糊搜索 根据书名查找书目
     *
     * @param bookName
     * @return
     */
    @Override
    public List<Book> queryBooksByName(String bookName) {
        return bookDao.queryBookByName(bookName);
    }

    /**
     * 根据书籍的id号查找书籍信息
     *
     * @param bId 书籍id
     * @return 返回书籍实体对象
     */
    @Override
    public Book queryBookById(Integer bId) {
        return bookDao.queryBookById(bId);
    }
}
