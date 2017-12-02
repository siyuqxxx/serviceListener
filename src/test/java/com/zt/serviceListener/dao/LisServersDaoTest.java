package com.zt.serviceListener.dao;

import com.zt.serviceListener.model.LisServersBean;
import com.zt.serviceListener.pojo.LisServer;
import com.zt.serviceListener.pojo.LisServers;
import org.junit.Test;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LisServersDaoTest {
    @Test
    public void LisServersDao() throws Exception {
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

        Set<LisServer> lisServers = new HashSet<LisServer>();

        lisServers.add(e);
        lisServers.add(e1);
        lisServers.add(e2);

        LisServers set = new LisServers();
        set.setLisServers(lisServers);

        String dir = System.getProperty("user.dir");
        String path = dir + "\\src\\resource_test\\lis_server.json";
        System.out.println(path);

        LisServersDao dao = new LisServersDao();

        LisServersBean bean = new LisServersBean();
        bean.addAll(set).getResolved();
        dao.write(path, bean);

        LisServersBean read = dao.read(path);

        System.out.println(read);

        assertEquals(bean.toPojo().getLisServers().size() - 1, read.toPojo().getLisServers().size());

//        for (LisServer s : read.getLisServers()) {
//            assertTrue(bean.getLisServers().contains(s));
//        }

        System.out.println(read.toHttpUrlSet());
    }

    @Test
    public void temp() throws Exception {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        int i = random.nextInt(100);
        System.out.print(i);
    }

}