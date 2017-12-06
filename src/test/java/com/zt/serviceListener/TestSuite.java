package com.zt.serviceListener;

import com.zt.serviceListener.dao.LisInterfaceUrlsDaoTest;
import com.zt.serviceListener.dao.LisServersDaoTest;
import com.zt.serviceListener.model.LisInterfaceUrlsBeanTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LisInterfaceUrlsDaoTest.class,
        LisServersDaoTest.class,
        LisInterfaceUrlsBeanTest.class,
})
public class TestSuite {
}
