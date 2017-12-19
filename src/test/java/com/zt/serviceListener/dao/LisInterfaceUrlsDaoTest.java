package com.zt.serviceListener.dao;

import com.zt.serviceListener.TestUtil;
import com.zt.serviceListener.bean.LisInterfaceUrlsBean;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LisInterfaceUrlsDaoTest {
    @Test
    public void UrlRoutingDao() throws Exception {
        // set up
        TestUtil.CreateLisInterfaceUrl.jsonFile();

        LisInterfaceUrlsDao dao = new LisInterfaceUrlsDao();

        LisInterfaceUrlsBean read = dao.read(TestUtil.JsonFile.LIS_INTERFACE_URL);

        System.out.println(read);

        assertEquals(TestUtil.CreateLisInterfaceUrl.urlSet_normal(), read.toPojo().getUrlSet());
    }
}