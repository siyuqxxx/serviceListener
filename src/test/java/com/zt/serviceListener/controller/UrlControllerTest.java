package com.zt.serviceListener.controller;

import com.zt.serviceListener.bean.LisInterfaceUrlsBean;
import com.zt.serviceListener.constants.Constants;
import com.zt.serviceListener.dao.LisInterfaceUrlsDao;
import com.zt.serviceListener.dao.LisServersDao;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class UrlControllerTest {
    @Test
    public void testGetUrlSet()
    {
        LisInterfaceUrlsBean IfUrlsBean = new LisInterfaceUrlsDao().read(Constants.BASE_DIR + "src\\test\\config\\lis_interface_urls.json");

        Set<String> serverUrls = new LisServersDao().read(Constants.BASE_DIR + "src\\test\\config\\lis_servers.json").toHttpUrlSet();

        Set<String> resultUrls = new HashSet<>();
        for (String url : serverUrls) {
            resultUrls.add(url + IfUrlsBean.getRandomUrlInterface().toUrl());
        }

        System.out.println(resultUrls);
    }
}