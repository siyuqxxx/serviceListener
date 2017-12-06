package com.zt.serviceListener.controller;

import com.zt.serviceListener.constants.Constants;
import com.zt.serviceListener.dao.LisInterfaceUrlsDao;
import com.zt.serviceListener.dao.LisServersDao;
import com.zt.serviceListener.model.LisInterfaceUrlsBean;

import java.util.HashSet;
import java.util.Set;

public class UrlController {
    public Set<String> getUrlSet() {
        LisInterfaceUrlsBean IfUrlsBean = new LisInterfaceUrlsDao().read(Constants.JsonFile.LIS_INTERFACE);

        Set<String> serverUrls = new LisServersDao().read(Constants.JsonFile.LIS_SERVER).toHttpUrlSet();

        Set<String> resultUrls = new HashSet<>();
        for (String url : serverUrls) {
            resultUrls.add(url + IfUrlsBean.getRandomUrlInterface().toUrl());
        }

        return resultUrls;
    }
}
