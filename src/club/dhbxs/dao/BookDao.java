package club.dhbxs.dao;

import club.dhbxs.beans.Book;

import java.util.List;

/**
 * @author 17235
 */
public interface BookDao {

    /**
     * 向Book表添加书籍信息
     *
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     * 根据ID删除对应书籍信息
     *
     * @param id
     * @return
     */
    int deleteBook(Integer id);

    /**
     * 更新Book表的信息
     *
     * @param book
     * @return
     */
    int updateBook(Book book);

    /**
     * 根据书的ID查找书籍信息
     *
     * @param id
     * @return
     */
    Book queryBookById(Integer id);

    /**
     * 从Book表里捞出所有数据放到List集合里
     *
     * @return
     */
    List<Book> queryBooks();

    /**
     * 根据书名模糊搜索
     *
     * @param bName 传入要查找的图书的书名
     * @return Book 返回查找后的结果Book对象
     */
    List<Book> queryBookByName(String bName);
}
