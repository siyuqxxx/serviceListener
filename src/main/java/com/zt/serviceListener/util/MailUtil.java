package com.zt.serviceListener.util;

import com.sun.mail.util.MailSSLSocketFactory;
import com.zt.serviceListener.bean.MailTemplateBean;
import com.zt.serviceListener.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailUtil {
    private static final Logger LOG = LoggerFactory.getLogger(MailUtil.class);

    public static void send(MailTemplateBean bean) {
        // 使用匿名内部类，用邮箱进行验证
        Message message = new MimeMessage(getSession());
        try {
            // 设置邮件发送方
            message.setFrom(bean.getFromInternetAddress());
            // 设置邮件标题
            message.setSubject(bean.toPojo().getSubject());
            // 设置邮件内容
            message.setContent(bean.toPojo().getContent(), bean.getContentType());
            // 设置邮件接收方
            message.addRecipients(Message.RecipientType.TO, bean.getReplyToInternetAddress());
            // 设置邮件抄送方
            message.addRecipients(Message.RecipientType.CC, bean.getCarbonCopyInternetAddress());
            // 发送邮件
            Transport.send(message);
        } catch (MessagingException e) {
            LOG.error("mail sending error.", e);
        }
    }

    private static Session getSession() {
        MailProperties p = new MailProperties().init();
        MailAuthenticator auth = new MailAuthenticator().setProperties(p.getAccountProperties());

        return Session.getInstance(p.getSessionProperties(), auth);
    }

    private static class MailProperties {
        private String propertiesFile = Constants.PropertiesFile.MAIL;

        private Properties sessionProperties = new Properties();

        private Properties accountProperties = new Properties();

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

        MailProperties init() {
            Properties props = PropertiesUtil.read(propertiesFile);

            setSessionProperties(props);
            setAccountProperties(props);

            return this;
        }

        Properties getSessionProperties() {
            return sessionProperties;
        }

        private void setSessionProperties(Properties p) {
            PropertiesUtil.copy("mail.debug", p, sessionProperties, "false");
            PropertiesUtil.copy("mail.transport.protocol", p, sessionProperties, "stmp");
            PropertiesUtil.copy("mail.smtp.host", p, sessionProperties, "smtp.qq.com");
            PropertiesUtil.copy("mail.smtp.auth", p, sessionProperties, "true");
            PropertiesUtil.copy("mail.smtp.ssl.enable", p, sessionProperties, "true");

            sessionProperties.put("mail.smtp.ssl.socketFactory", getMailSSLSocketFactory());
        }

        Properties getAccountProperties() {
            return accountProperties;
        }

        private void setAccountProperties(Properties p) {
            PropertiesUtil.copy("mail.account.name", p, accountProperties);
            PropertiesUtil.copy("mail.account.password", p, accountProperties);
        }
    }

    /**
     * 通过用户名和密码进行验证
     */
    private static class MailAuthenticator extends Authenticator {
        private String name = "";
        private String password = "";

        MailAuthenticator setProperties(Properties p) {
            this.name = PropertiesUtil.getValue(p, "mail.account.name");
            this.password = PropertiesUtil.getValue(p, "mail.account.password");

            return this;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(name, password);
        }
    }
}
