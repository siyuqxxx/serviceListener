package com.zt.serviceListener.dao;

import com.zt.serviceListener.bean.SchedulerInfosBean;
import com.zt.serviceListener.pojo.Quartz.SchedulerInfos;
import com.zt.serviceListener.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchedulerInfosDao implements IDao<SchedulerInfosBean> {
    private static final Logger LOG = LoggerFactory.getLogger(SchedulerInfosDao.class);

    @Override
    public SchedulerInfosBean read(String path) {
        try {
            SchedulerInfos set = JSONUtil.jsonFile2Obj(path, SchedulerInfos.class);
            return new SchedulerInfosBean().addAll(set).removeDisable();
        } catch (Exception e) {
            LOG.error("unknown exception!", e);
            return new SchedulerInfosBean();
        }
    }

    @Override
    public void write(String path, SchedulerInfosBean obj) {
        JSONUtil.obj2JsonFile(path, obj.toPojo());
    }
}
