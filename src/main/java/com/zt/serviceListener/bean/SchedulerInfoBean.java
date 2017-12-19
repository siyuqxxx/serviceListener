package com.zt.serviceListener.bean;

import com.zt.serviceListener.pojo.Quartz.SchedulerInfo;

import java.util.Objects;

public class SchedulerInfoBean implements IBean<SchedulerInfo, SchedulerInfoBean>, IEnable {
    private SchedulerInfo schedulerInfo = new SchedulerInfo();

    public SchedulerInfoBean() {
    }

    public SchedulerInfoBean(SchedulerInfo s) {
        addAll(s);
    }

    public boolean hasTriggers() {
        return !schedulerInfo.getTriggers().isEmpty();
    }

    @Override
    public SchedulerInfoBean addAll(SchedulerInfo e) {
        if (Objects.nonNull(e)) {
            this.schedulerInfo = e;
        }
        return this;
    }

    @Override
    public SchedulerInfo toPojo() {
        return this.schedulerInfo;
    }

    @Override
    public void clean() {
        this.schedulerInfo = new SchedulerInfo();
    }

    @Override
    public boolean isEnable() {
        return schedulerInfo.isEnable();
    }

    @Override
    public String toString() {
        return "SchedulerInfoBean{" +
                "schedulerInfo=" + schedulerInfo +
                '}';
    }
}
