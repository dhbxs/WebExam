package club.dhbxs.service.impl;

import club.dhbxs.beans.Book;
import club.dhbxs.dao.impl.BookDaoImpl;
import club.dhbxs.service.ModifyBook;

/**
 * @ClassName ModifyBookImpl
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/7/1 下午 10:32
 * @Version 1.0
 **/
public class ModifyBookImpl implements ModifyBook {
    /**
     * 管理员修改图书信息的service服务层
     *
     * @param book 图书id
     */
    @Override
    public void modifyBook(Book book) {
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.updateBook(book);
    }
}
