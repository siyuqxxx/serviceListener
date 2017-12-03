package com.zt.serviceListener;

import com.zt.serviceListener.dao.LisInterfaceUrlsDaoTest;
import com.zt.serviceListener.dao.LisServersDaoTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LisInterfaceUrlsDaoTest.class,
        LisServersDaoTest.class
})
public class TestSuite {
}
