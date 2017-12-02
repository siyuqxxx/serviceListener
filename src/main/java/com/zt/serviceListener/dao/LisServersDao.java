package com.zt.serviceListener.dao;

import com.zt.serviceListener.model.LisServersBean;
import com.zt.serviceListener.pojo.LisServers;
import com.zt.serviceListener.util.JSONUtil;

public class LisServersDao implements IDao<LisServersBean>{
    @Override
    public LisServersBean read(String path) {
        LisServers set = JSONUtil.jsonFile2Obj(path, LisServers.class);

        return new LisServersBean().addAll(set).getResolved();
    }

    @Override
    public void write(String path, LisServersBean obj) {
        JSONUtil.obj2JsonFile(path, obj.toPojo());
    }
}
