package club.dhbxs.service;

import org.apache.commons.mail.EmailException;

/**
 * @ClassName EmailVerify
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/7/2 16:29
 * @Version 1.0
 **/
public interface EmailVerify {
    /**
     * 管理员修改密码时发送邮箱验证码
     *
     * @param eAddress
     * @return
     * @throws EmailException
     */
    String emailSend(String eAddress) throws EmailException;
}
