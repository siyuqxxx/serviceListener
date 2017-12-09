package com.zt.serviceListener.dao;

import com.zt.serviceListener.TestUtil;
import com.zt.serviceListener.bean.MailTemplatesBean;
import com.zt.serviceListener.pojo.MailTemplate;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MailTemplatesDaoTest {
    @Test
    public void testMailTemplatesDao() throws Exception {
        // set up
        TestUtil.CreateMailTemplate.jsonFile();

        // test
        MailTemplatesDao dao = new MailTemplatesDao();
        MailTemplatesBean read = dao.read(TestUtil.JsonFile.Mail_Template);

        System.out.println(read);

        Set<MailTemplate> testSet = TestUtil.CreateMailTemplate.mailSet();
        Set<MailTemplate> mailSet = read.toPojo().getMailSet();
        assertEquals(testSet.size() - 1, mailSet.size());

        for (MailTemplate m : mailSet) {
            assertTrue(testSet.contains(m));
        }
    }

}