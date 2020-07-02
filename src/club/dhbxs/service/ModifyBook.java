package club.dhbxs.service;

import club.dhbxs.beans.Book;

/**
 * @ClassName ModifyBook
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/7/1 下午 10:30
 * @Version 1.0
 **/
public interface ModifyBook {
    /**
     * 管理员修改图书信息的业务逻辑
     * @param book 图书book对象实体
     */
    void modifyBook(Book book);
}
