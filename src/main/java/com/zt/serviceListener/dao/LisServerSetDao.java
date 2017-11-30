package com.zt.serviceListener.dao;

import com.zt.serviceListener.model.LisServerSetBean;
import com.zt.serviceListener.pojo.LisServerSet;
import com.zt.serviceListener.util.JSONUtil;

public class LisServerSetDao {
    public LisServerSetBean read(String path) {
        LisServerSet set = JSONUtil.jsonFile2Obj(path, LisServerSet.class);

        return new LisServerSetBean().addAll(set);
    }

    public void write(String path, LisServerSetBean set) {
        JSONUtil.obj2JsonFile(path, set.getLisServerSet());
    }
}
