package club.dhbxs.service.impl;

import club.dhbxs.service.EmailVerify;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.Random;

/**
 * @ClassName EmailVerifyImpl
 * @Author 17235
 * @Description TODO
 * @Date Created in 2020/7/2 16:34
 * @Version 1.0
 **/
public class EmailVerifyImpl implements EmailVerify {
    /**
     * 管理员修改密码时发送邮箱验证码
     *
     * @param eAddress 邮箱地址
     * @return 返回验证码
     */
    @Override
    public String emailSend(String eAddress) throws EmailException {
        //随机生成6位数字验证码
        Random random = new Random();
        int s = random.nextInt(999999);
        String captcha = String.valueOf(s);

        HtmlEmail htmlEmail = new HtmlEmail();
        //设置邮箱的smtp服务器地址
        htmlEmail.setHostName("smtp.163.com");
        htmlEmail.setCharset("utf-8");
        htmlEmail.addTo(eAddress);
        htmlEmail.setFrom("yao1723@163.com","DHBXS");
        htmlEmail.setAuthentication("yao1723@163.com","GRCYDOKOINCIVGOY");

        //设置发送内容
        htmlEmail.setSubject("图书管理商城验证码");
        htmlEmail.setMsg("您的验证码是：" + captcha);
        htmlEmail.send();

        return captcha;
    }
}
