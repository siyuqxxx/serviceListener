package com.zt.serviceListener;

import com.zt.serviceListener.bean.LisInterfaceUrlsBeanTest;
import com.zt.serviceListener.bean.LisServersBeanTest;
import com.zt.serviceListener.bean.MailTemplateBeanTest;
import com.zt.serviceListener.controller.UrlControllerTest;
import com.zt.serviceListener.dao.LisInterfaceUrlsDaoTest;
import com.zt.serviceListener.dao.LisServersDaoTest;
import com.zt.serviceListener.dao.MailTemplatesDaoTest;
import com.zt.serviceListener.util.ArraysUtilTest;
import com.zt.serviceListener.util.MailUtilTest;
import com.zt.serviceListener.util.UrlDetectUtilTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LisInterfaceUrlsBeanTest.class,
        LisServersBeanTest.class,
        MailTemplateBeanTest.class,
        UrlControllerTest.class,
        LisInterfaceUrlsDaoTest.class,
        LisServersDaoTest.class,
        MailTemplatesDaoTest.class,
        ArraysUtilTest.class,
        MailUtilTest.class,
        UrlDetectUtilTest.class
})
public class TestSuite {
}
