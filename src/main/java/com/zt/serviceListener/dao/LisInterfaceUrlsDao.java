package com.zt.serviceListener.dao;

import com.zt.serviceListener.bean.LisInterfaceUrlsBean;
import com.zt.serviceListener.pojo.LisInterfaceUrls;
import com.zt.serviceListener.util.JSONUtil;

public class LisInterfaceUrlsDao implements IDao<LisInterfaceUrlsBean> {
    @Override
    public LisInterfaceUrlsBean read(String path) {
        LisInterfaceUrls urls = JSONUtil.jsonFile2Obj(path, LisInterfaceUrls.class);

        // TODO 对url做一些基本校验，比如 正反斜杠的问题，策略同 LisServersDao
        return new LisInterfaceUrlsBean().addAll(urls).removeDisable();
    }

    @Override
    public void write(String path, LisInterfaceUrlsBean obj) {
        JSONUtil.obj2JsonFile(path, obj.toPojo());
    }
}
