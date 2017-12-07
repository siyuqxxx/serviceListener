package com.zt.serviceListener.dao;

import com.zt.serviceListener.bean.LisServersBean;
import com.zt.serviceListener.pojo.LisServer;
import com.zt.serviceListener.pojo.LisServers;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LisServersDaoTest {
    @Test
    public void LisServersDao() throws Exception {

        // set up
        LisServer e = new LisServer();
        e.setIp("123456234712" ); // 检查不能被解析的 host
        e.setPort(8081);
        e.setUserName("root");
        e.setPassword("Test1234_");

        LisServer e1 = new LisServer();
        e1.setIp("123.0.0.1");
        e1.setPort(8081);

        LisServer e2 = new LisServer();
        e2.setIp("42.247.27.226");
        e2.setPort(8081);
        e2.setDescription("重庆第二师范学院");

        LisServer e3 = new LisServer();
        e3.setIp("123.0.0.2");
        e3.setPort(8081);
        e3.setEnable(false);

        Set<LisServer> lisServers = new HashSet<>();
        lisServers.add(e);
        lisServers.add(e1);
        lisServers.add(e2);
        lisServers.add(e3);

        LisServers set = new LisServers();
        set.setLisServers(lisServers);

        LisServersBean bean = new LisServersBean().addAll(set);
        String path = System.getProperty("user.dir") + "\\src\\resource_test\\lis_servers.json";
        LisServersDao dao = new LisServersDao();

        // test
        dao.write(path, bean);

        LisServersBean read = dao.read(path);

        System.out.println(read);

        assertEquals(bean.toPojo().getLisServers().size() - 2, read.toPojo().getLisServers().size());

        for (LisServer s : read.toPojo().getLisServers()) {
            assertTrue(bean.toPojo().getLisServers().contains(s));
        }

        System.out.println(read.toHttpUrlSet());
    }
}