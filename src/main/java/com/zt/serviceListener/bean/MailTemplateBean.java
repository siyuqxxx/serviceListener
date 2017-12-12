package com.zt.serviceListener.bean;

import com.zt.serviceListener.constants.Constants;
import com.zt.serviceListener.pojo.MailTemplate;
import com.zt.serviceListener.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.Objects;

public class MailTemplateBean implements IBean<MailTemplate, MailTemplateBean>, IEnable {
    private static final Logger LOG = LoggerFactory.getLogger(MailTemplateBean.class);

    private MailTemplate mail = new MailTemplate();

    public MailTemplateBean() {
    }

    public MailTemplateBean(MailTemplate e) {
        addAll(e);
    }

    public int getId() {
        return mail.getId();
    }

    public void setContent(String content) {
        mail.setContent(StrUtil.toValid(content));
    }

    public InternetAddress getFromInternetAddress() {
        return mailStr2Address(mail.getFrom());
    }

    public InternetAddress[] getReplyToInternetAddress() {
        return mailStr2AddressArr(mail.getReplyTo());
    }

    public InternetAddress[] getCarbonCopyInternetAddress() {
        return mailStr2AddressArr(mail.getCarbonCopy());
    }

    public String getContentType() {
        String content = mail.getContentType();
        return StrUtil.invalidStr(content) ? Constants.Mail.TEXT_PLAIN_UTF8 : content.trim();
    }

    @Override
    public MailTemplateBean addAll(MailTemplate e) {
        if (Objects.nonNull(e)) {
            this.mail = e;
        }
        return this;
    }

    @Override
    public MailTemplate toPojo() {
        return this.mail;
    }

    @Override
    public void clean() {
        this.mail = new MailTemplate();

    }

    @Override
    public boolean isEnable() {
        return mail.isEnable();
    }

    @Override
    public String toString() {
        return "MailTemplateBean{" +
                "mail=" + mail +
                '}';
    }

    private static InternetAddress mailStr2Address(String address) {
        address = StrUtil.toValid(address);
        try {
            return new InternetAddress(address);
        } catch (AddressException e) {
            LOG.warn("Parse mail address error. " + address, e);
            return new InternetAddress();
        }
    }

    private static InternetAddress[] mailStr2AddressArr(String addresses) {
        addresses = StrUtil.toValid(addresses);
        try {
            return InternetAddress.parse(addresses);
        } catch (AddressException e) {
            LOG.warn("Parse mail address error. " + addresses, e);
            return new InternetAddress[]{};
        }
    }
}
