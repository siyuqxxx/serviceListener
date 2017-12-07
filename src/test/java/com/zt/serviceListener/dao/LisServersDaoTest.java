package com.zt.serviceListener.dao;

import com.zt.serviceListener.TestUtil;
import com.zt.serviceListener.bean.LisServersBean;
import com.zt.serviceListener.pojo.LisServer;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LisServersDaoTest {
    @Test
    public void LisServersDao() throws Exception {

        // set up
        TestUtil.CreateLisServer.jsonFile();

        // test
        LisServersDao dao = new LisServersDao();
        LisServersBean read = dao.read(TestUtil.JsonFile.LIS_SERVERS);

        System.out.println(read);

        Set<LisServer> testSet = TestUtil.CreateLisServer.serverSet();
        assertEquals(testSet.size() - 2, read.toPojo().getServerSet().size());

        for (LisServer s : read.toPojo().getServerSet()) {
            assertTrue(testSet.contains(s));
        }

        System.out.println(read.toHttpUrlSet());
    }
}