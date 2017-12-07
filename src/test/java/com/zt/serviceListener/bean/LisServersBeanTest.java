package com.zt.serviceListener.bean;

import com.zt.serviceListener.TestUtil;
import com.zt.serviceListener.pojo.LisServer;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LisServersBeanTest {
    @Test
    public void testRemoveEnable() throws Exception {
        LisServersBean bean = TestUtil.CreateLisServer.serversBean();

        Set<LisServer> lisServers = bean.reomveDisable().toPojo().getServerSet();

        Set<LisServer> expected = new HashSet<>();
        expected.add(TestUtil.CreateLisServer.normal_1());
        expected.add(TestUtil.CreateLisServer.normal_2());
        expected.add(TestUtil.CreateLisServer.unresolved());

        assertEquals(expected, lisServers);
    }
}