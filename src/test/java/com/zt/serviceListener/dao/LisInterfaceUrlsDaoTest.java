package com.zt.serviceListener.dao;

import com.zt.serviceListener.bean.LisInterfaceUrlsBean;
import com.zt.serviceListener.pojo.LisInterfaceUrl;
import com.zt.serviceListener.pojo.LisInterfaceUrls;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

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

        LisInterfaceUrl[] urlRouting = new LisInterfaceUrl[2];
        urlRouting[0] = urlA;
        urlRouting[1] = urlB;

        LisInterfaceUrls lisInterfaceUrls = new LisInterfaceUrls();
        lisInterfaceUrls.setUrls(urlRouting);

        // test
        LisInterfaceUrlsBean urls = new LisInterfaceUrlsBean().addAll(lisInterfaceUrls);
        String path = System.getProperty("user.dir") + "\\src\\resource\\LisInterfaceUrls.json";
        LisInterfaceUrlsDao dao = new LisInterfaceUrlsDao();

        dao.write(path, urls);

        LisInterfaceUrlsBean read = dao.read(path);

        System.out.println(read);

        assertArrayEquals(urls.toPojo().getUrls(), read.toPojo().getUrls());
    }

//    @Test
//    public void temp() throws Exception {
//        Set<String>
//    }
}