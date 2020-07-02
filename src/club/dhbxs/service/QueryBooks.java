package club.dhbxs.service;

import club.dhbxs.beans.Book;

import java.util.List;

/**
 * @ClassName QueryBooks
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/6/30 上午 11:50
 * @Version 1.0
 **/
public interface QueryBooks {
    /**
     * 首页加载所有书籍信息
     *
     * @return 所有书籍信息
     */
    List<Book> queryAllBooks();

    /**
     * 模糊搜索 根据书名查找书目
     *
     * @param bookName
     * @return
     */
    List<Book> queryBooksByName(String bookName);

    /**
     * 根据书籍的id号查找书籍信息
     * @param bId 书籍id
     * @return 返回书籍实体对象
     */
    Book queryBookById(Integer bId);
}
