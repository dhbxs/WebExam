package club.dhbxs.service.impl;

import club.dhbxs.beans.Borrow;
import club.dhbxs.dao.BorrowDao;
import club.dhbxs.dao.impl.BorrowDaoImpl;
import club.dhbxs.service.QueryHistory;

import java.util.List;

/**
 * @ClassName QueryHistoryImpl
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/6/30 上午 10:29
 * @Version 1.0
 **/
public class QueryHistoryImpl implements QueryHistory {
    /**
     * 查找用户的借阅信息
     *
     * @param uId 用户id
     * @return 返回借阅历史集合
     */
    @Override
    public List<Borrow> queryHistoryByuId(Integer uId) {
        BorrowDao borrowDao = new BorrowDaoImpl();
        return borrowDao.queryBorrowByUid(uId);
    }
}
