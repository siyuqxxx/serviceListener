package com.zt.serviceListener.dao;

import com.zt.serviceListener.model.LisServersBean;
import com.zt.serviceListener.pojo.LisServers;
import com.zt.serviceListener.util.JSONUtil;

public class LisServersDao implements IDao<LisServersBean>{
    @Override
    public LisServersBean read(String path) {
        LisServers set = JSONUtil.jsonFile2Obj(path, LisServers.class);

        // TODO 只在 init 数据的时候做校验，
        // 校验完毕以后生成一个sha1，read 的时候只做sha1校验，如果一致则不做 init
        // 用于改善性能
        return new LisServersBean().addAll(set).getResolved();
    }

    @Override
    public void write(String path, LisServersBean obj) {
        JSONUtil.obj2JsonFile(path, obj.toPojo());
    }
}
