package com.zt.serviceListener.dao;

import com.zt.serviceListener.bean.MailTemplatesBean;
import com.zt.serviceListener.pojo.MailTemplates;
import com.zt.serviceListener.util.JSONUtil;

public class MailTemplatesDao implements IDao<MailTemplatesBean> {
    @Override
    public MailTemplatesBean read(String path) {
        MailTemplates set = JSONUtil.jsonFile2Obj(path, MailTemplates.class);
        return new MailTemplatesBean().addAll(set).removeDisable();
    }

    @Override
    public void write(String path, MailTemplatesBean obj) {
        JSONUtil.obj2JsonFile(path, obj.toPojo());
    }
}
