package club.dhbxs.service;

/**
 * @ClassName DeleteBook
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/6/30 下午 10:51
 * @Version 1.0
 **/
public interface DeleteBook {
    /**
     * 删除图书信息，将其移出库
     * @param bId 图书ID编号
     */
    void deleteBook(Integer bId);
}
