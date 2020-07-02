package club.dhbxs.test;

import club.dhbxs.service.impl.EmailVerifyImpl;
import org.apache.commons.mail.EmailException;
import org.junit.Test;

/**
 * @author 17235
 */
public class EmailVerifyTest {

    @Test
    public void emailSend() throws EmailException {
        EmailVerifyImpl emailVerify = new EmailVerifyImpl();
        String s = emailVerify.emailSend("1723544366@qq.com");
        System.out.println(s);
    }
}