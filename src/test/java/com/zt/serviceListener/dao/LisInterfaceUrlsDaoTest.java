package com.zt.serviceListener.dao;

import com.zt.serviceListener.model.LisInterfaceUrlsBean;
import com.zt.serviceListener.pojo.LisInterfaceUrl;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class LisInterfaceUrlsDaoTest {
    @Test
    public void UrlRoutingDao() throws Exception {
        LisInterfaceUrl[] urlRouting = new LisInterfaceUrl[2];

        LisInterfaceUrl urlA = new LisInterfaceUrl();
        urlA.setDescription("find book by title");
        urlA.setLisInterfaceUrl("/datasnap/rest/TInterFace/searchbook/title/java ");

        LisInterfaceUrl urlB = new LisInterfaceUrl();
        urlB.setDescription("get new books");
        urlB.setLisInterfaceUrl("/datasnap/rest/TInterFace/newbooks/1");

        urlRouting[0] = urlA;
        urlRouting[1] = urlB;

        LisInterfaceUrlsBean urls = new LisInterfaceUrlsBean();
        urls.setUrls(urlRouting);

        LisInterfaceUrlsDao dao = new LisInterfaceUrlsDao();
        String path = "D:\\code\\serviceListener\\src\\resource\\LisInterfaceUrls.json";
        dao.write(path, urls);

        LisInterfaceUrlsBean read = dao.read(path);

        System.out.println(read);

        assertArrayEquals(urls.getUrls(), read.getUrls());
    }
}