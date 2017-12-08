package com.zt.serviceListener.util;

import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailUtil {
    private static final Logger LOG = LoggerFactory.getLogger(MailUtil.class);
    public static void qqSender() {
        // 使用匿名内部类，用邮箱进行验证
        Message message = new MimeMessage(getSession());
        try {
            // 设置邮件发送方
            message.setFrom(new InternetAddress("siyuqxxx@qq.com"));
            // 设置邮件标题
            message.setSubject("测试");
            // 设置邮件内容
            message.setContent("测试", "text/html;charset=utf-8");
            // 设置邮件接收方
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    "siyuqxxx@qq.com"));

            // 发送邮件
            Transport.send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static Session getSession() {
        Properties props = PropertiesUtil.read("mail.properties");
        props.put("mail.smtp.ssl.socketFactory", getMailSSLSocketFactory());

        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 通过用户名和密码进行验证
                return new PasswordAuthentication(props.getProperty("mail.account.sender"),
                        props.getProperty("mail.account.password"));
            }
        });
    }

    private static MailSSLSocketFactory getMailSSLSocketFactory() {
        MailSSLSocketFactory msf = null;
        try {
            msf = new MailSSLSocketFactory();
            msf.setTrustAllHosts(true);
        } catch (GeneralSecurityException e) {
            LOG.warn("get MailSSLSocketFactory error", e);
        }
        return msf;
    }

    public static void main(String[] args)
    {
        MailUtil.qqSender();
    }
}
