package com.zt.serviceListener.dao;

import com.zt.serviceListener.model.LisServersBean;
import com.zt.serviceListener.pojo.LisServer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LisServersDaoTest {
    @Test
    public void LisServersDao() throws Exception {
        LisServersBean set = new LisServersBean();
        LisServer e = new LisServer();
        e.setIp("12345678" );
        e.setPort(8081);
        e.setUserName("root");
        e.setPassword("Test1234_");

        LisServer e1 = new LisServer();
        e1.setIp("123.0.0.1");
        e1.setPort(8081);

        LisServer e2 = new LisServer();
        e2.setIp("42.247.27.226");
        e2.setPort(8081);

        set.getLisServers().add(e);
        set.getLisServers().add(e1);
        set.getLisServers().add(e2);

        String dir = System.getProperty("user.dir");
        String path = dir + "\\src\\resource\\lis_server.json";
        System.out.println(path);

        LisServersDao dao = new LisServersDao();
        dao.write(path, set);

        LisServersBean read = dao.read(path);

        System.out.println(read);

        assertEquals(set.getLisServers().size(), read.getLisServers().size());

        assertTrue(set.getLisServers().containsAll(read.getLisServers()));
    }

}