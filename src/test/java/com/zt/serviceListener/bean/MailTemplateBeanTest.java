package com.zt.serviceListener.bean;

import com.zt.serviceListener.TestUtil;
import com.zt.serviceListener.pojo.MailTemplate;
import org.junit.Test;

import javax.mail.internet.InternetAddress;

import static org.junit.Assert.assertEquals;

public class MailTemplateBeanTest {
    @Test
    public void testGetFromInternetAddress() throws Exception {
        MailTemplate mail = TestUtil.CreateMailTemplate.mail_enable();
        MailTemplateBean bean = new MailTemplateBean().addAll(mail);

        InternetAddress fromInternetAddress = bean.getFromInternetAddress();
        assertEquals("qian siyu <siyuq@qq.com>", fromInternetAddress.toString());
    }

    @Test
    public void testGetReplyToInternetAddress() throws Exception {
        MailTemplate mail = TestUtil.CreateMailTemplate.mail_enable();
        MailTemplateBean bean = new MailTemplateBean().addAll(mail);

        InternetAddress[] replayToInternetAddressArr = bean.getReplyToInternetAddress();
        assertEquals(2, replayToInternetAddressArr.length);
    }
}