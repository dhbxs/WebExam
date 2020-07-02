package club.dhbxs.service;

import club.dhbxs.beans.Root;

/**
 * @ClassName SearchRoot
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/7/2 15:56
 * @Version 1.0
 **/
public interface SearchRoot {
    /**
     * 根据root用户的ID查找root用户Id信息
     * @param Id root用户id
     * @return 返回root用户对象
     */
    Root searchRoot(Integer Id);
}
