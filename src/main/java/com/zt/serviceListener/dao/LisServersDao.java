package com.zt.serviceListener.dao;

import com.zt.serviceListener.model.LisServersBean;
import com.zt.serviceListener.pojo.LisServers;
import com.zt.serviceListener.util.JSONUtil;

public class LisServersDao {
    public LisServersBean read(String path) {
        LisServers set = JSONUtil.jsonFile2Obj(path, LisServers.class);

        return new LisServersBean().addAll(set);
    }

    public void write(String path, LisServersBean set) {
        JSONUtil.obj2JsonFile(path, set);
    }
}
