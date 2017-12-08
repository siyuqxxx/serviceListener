package com.zt.serviceListener;

import com.zt.serviceListener.bean.LisInterfaceUrlsBeanTest;
import com.zt.serviceListener.bean.LisServersBeanTest;
import com.zt.serviceListener.dao.LisInterfaceUrlsDaoTest;
import com.zt.serviceListener.dao.LisServersDaoTest;
import com.zt.serviceListener.util.PropertiesUtilTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LisInterfaceUrlsDaoTest.class,
        LisServersBeanTest.class,
        LisServersDaoTest.class,
        LisInterfaceUrlsBeanTest.class,
        PropertiesUtilTest.class
})
public class TestSuite {
}
