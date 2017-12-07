package com.zt.serviceListener.dao;

import com.zt.serviceListener.bean.LisInterfaceUrlsBean;
import com.zt.serviceListener.pojo.LisInterfaceUrl;
import com.zt.serviceListener.pojo.LisInterfaceUrls;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LisInterfaceUrlsDaoTest {
    @Test
    public void UrlRoutingDao() throws Exception {
        // set up
        LisInterfaceUrl urlA = new LisInterfaceUrl();
        urlA.setDescription("find book by title");
        urlA.setLisInterfaceUrl("/datasnap/rest/TInterFace/searchbook/title/java ");

        LisInterfaceUrl urlB = new LisInterfaceUrl();
        urlB.setDescription("get new books");
        urlB.setLisInterfaceUrl("/datasnap/rest/TInterFace/newbooks/1");

        Set<LisInterfaceUrl> interfaces = new HashSet<>();
        interfaces.add(urlA);
        interfaces.add(urlB);

        LisInterfaceUrls lisInterfaceUrls = new LisInterfaceUrls();
        lisInterfaceUrls.setUrlSet(interfaces);

        // test
        LisInterfaceUrlsBean urls = new LisInterfaceUrlsBean().addAll(lisInterfaceUrls);
        String path = System.getProperty("user.dir") + "\\src\\resource\\LisInterfaceUrls.json";
        LisInterfaceUrlsDao dao = new LisInterfaceUrlsDao();

        dao.write(path, urls);

        LisInterfaceUrlsBean read = dao.read(path);

        System.out.println(read);

        assertEquals(urls.toPojo().getUrlSet(), read.toPojo().getUrlSet());
    }
}