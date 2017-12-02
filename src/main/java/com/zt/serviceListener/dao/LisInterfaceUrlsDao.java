package com.zt.serviceListener.dao;

import com.zt.serviceListener.model.LisInterfaceUrlsBean;
import com.zt.serviceListener.pojo.LisInterfaceUrls;
import com.zt.serviceListener.util.JSONUtil;

public class LisInterfaceUrlsDao implements IDao<LisInterfaceUrlsBean> {
    @Override
    public LisInterfaceUrlsBean read(String path) {
        LisInterfaceUrls urls = JSONUtil.jsonFile2Obj(path, LisInterfaceUrls.class);

        return new LisInterfaceUrlsBean().addAll(urls);
    }

    @Override
    public void write(String path, LisInterfaceUrlsBean obj) {
        JSONUtil.obj2JsonFile(path, obj);
    }
}
