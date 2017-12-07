package com.zt.serviceListener.bean;

import com.zt.serviceListener.pojo.LisServer;
import com.zt.serviceListener.pojo.LisServers;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LisServersBeanTest {
    @Test
    public void testGetEnable() throws Exception {
        LisServer e1 = new LisServer();
        e1.setDescription("test_enable_1");
        e1.setIp("127.0.0.1");
        e1.setEnable(true);
        LisServer e2 = new LisServer();
        e2.setDescription("test_enable_2");
        e2.setIp("127.0.0.2");
        e2.setEnable(true);
        LisServer e3 = new LisServer();
        e3.setDescription("test_disable_1");
        e3.setIp("127.0.0.3");
        e3.setEnable(false);
        LisServer e4 = new LisServer();
        e4.setDescription("test_disable_2");
        e4.setIp("127.0.0.4");
        e4.setEnable(false);

        Set<LisServer> s = new HashSet<>();
        s.add(e1);
        s.add(e2);
        s.add(e3);
        s.add(e4);

        LisServers servers = new LisServers();
        servers.setLisServers(s);

        LisServersBean bean = new LisServersBean();
        bean.addAll(servers);

        Set<LisServer> lisServers = bean.getEnable().toPojo().getLisServers();

        Set<LisServer> exceptSet = new HashSet<>();
        exceptSet.add(e1);
        exceptSet.add(e2);

        assertEquals(exceptSet, lisServers);
    }

}