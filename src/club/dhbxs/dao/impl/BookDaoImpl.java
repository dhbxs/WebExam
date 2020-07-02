package club.dhbxs.dao.impl;

import club.dhbxs.beans.Book;
import club.dhbxs.dao.BookDao;

import java.util.List;

/**
 * @author ：1723
 * @date ：Created in 2020/6/27 下午 4:25
 * @description：
 * @version: 1.0
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    /**
     * 向Book表添加书籍信息
     *
     * @param book 传入图书对象
     * @return 返回状态码
     */
    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO book(bId,bName,bAuthor,bPress,bImg,bNumber,bBorrow) VALUES(?,?,?,?,?,?,?);";
        return update(sql,book.getbId(),book.getbName(),book.getbAuthor(),book.getbPress(),book.getbImg(),book.getbNumber(),book.getbBorrow());
    }

    /**
     * 根据ID删除对应书籍信息
     *
     * @param id 传入要删除书籍的id号
     * @return 返回状态码
     */
    @Override
    public int deleteBook(Integer id) {
        String sql = "DELETE FROM book WHERE bId = ?;";
        return update(sql, id);
    }

    /**
     * 更新Book表的信息
     *
     * @param book 传入更改好的book对象
     * @return 返回状态码
     */
    @Override
    public int updateBook(Book book) {
        String sql = "UPDATE book SET bName=?,bAuthor=?,bPress=?,bImg=?,bNumber=?,bBorrow=? WHERE bId = ?;";
        return update(sql,book.getbName(),book.getbAuthor(),book.getbPress(),book.getbImg(),book.getbNumber(),book.getbBorrow(),book.getbId());
    }

    /**
     * 根据书的ID查找书籍信息
     *
     * @param id 传入要查找的图书的id
     * @return Book 返回查找后的结果Book对象
     */
    @Override
    public Book queryBookById(Integer id) {
        String sql = "SELECT * FROM book WHERE bId = ?";
        return queryForOne(Book.class,sql,id);
    }

    /**
     * 从Book表里捞出所有数据放到List集合里
     *
     * @return 返回结果集合，book泛型的list
     */
    @Override
    public List<Book> queryBooks() {
        String sql = "SELECT * FROM book;";
        return queryForList(Book.class,sql);
    }

    /**
     * 根据书名模糊搜索
     *
     * @param bName 传入要查找的图书的书名
     * @return Book 返回查找后的结果Book对象
     */
    @Override
    public List<Book> queryBookByName(String bName) {
        String sql = "SELECT * FROM book WHERE bName like ?";
        return queryForList(Book.class,sql,"%" + bName + "%");
    }
}
