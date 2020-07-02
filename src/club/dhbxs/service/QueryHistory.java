package club.dhbxs.service;

import club.dhbxs.beans.Borrow;

import java.util.List;

/**
 * @ClassName QueryHistory
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/6/30 上午 10:27
 * @Version 1.0
 **/
public interface QueryHistory {
    /**
     * 查找用户的借阅信息
     * @param uId 用户id
     * @return 返回借阅历史集合
     */
    List<Borrow> queryHistoryByuId(Integer uId);
}
