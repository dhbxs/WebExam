package club.dhbxs.service.impl;

import club.dhbxs.dao.BookDao;
import club.dhbxs.dao.impl.BookDaoImpl;
import club.dhbxs.service.DeleteBook;

/**
 * @ClassName DeleteBookImpl
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/6/30 下午 10:53
 * @Version 1.0
 **/
public class DeleteBookImpl implements DeleteBook {
    /**
     * 删除图书信息，将其移出库
     *
     * @param bId 图书ID编号
     */
    @Override
    public void deleteBook(Integer bId) {
        BookDao bookDao = new BookDaoImpl();
        bookDao.deleteBook(bId);
    }
}
