package com.zt.serviceListener.bean;

import com.zt.serviceListener.pojo.Quartz.SchedulerInfo;
import com.zt.serviceListener.pojo.Quartz.SchedulerInfos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class SchedulerInfosBean implements IBean<SchedulerInfos, SchedulerInfosBean> {
    private Set<SchedulerInfoBean> schedulerInfosBean = new HashSet<>();

    public SchedulerInfosBean removeDisable() {
        SchedulerInfosBean bean = new SchedulerInfosBean();
        bean.setSchedulerInfosBean(schedulerInfosBean.stream().filter(SchedulerInfoBean::isEnable).collect(Collectors.toSet()));
        return bean;
    }

    public Set<SchedulerInfoBean> getSchedulerInfosBean() {
        return schedulerInfosBean;
    }

    @Override
    public SchedulerInfosBean addAll(SchedulerInfos e) {
        if (Objects.nonNull(e)) {
            Set<SchedulerInfo> schedulerInfos = e.getSchedulerInfoSet();
            if (Objects.nonNull(schedulerInfos)) {
                schedulerInfosBean.addAll(schedulerInfos.stream().map(SchedulerInfoBean::new).collect(Collectors.toSet()));
            }
        }
        return this;
    }

    @Override
    public SchedulerInfos toPojo() {
        SchedulerInfos schedulerInfos = new SchedulerInfos();
        schedulerInfos.setSchedulerInfoSet(schedulerInfosBean.stream().map(SchedulerInfoBean::toPojo).collect(Collectors.toSet()));
        return schedulerInfos;
    }

    @Override
    public void clean() {
        this.schedulerInfosBean = new HashSet<>();
    }

    @Override
    public String toString() {
        return "SchedulerInfosBean{" +
                "schedulerInfosBean=" + schedulerInfosBean +
                '}';
    }

    private void setSchedulerInfosBean(Set<SchedulerInfoBean> schedulerInfosBean) {
        this.schedulerInfosBean.addAll(schedulerInfosBean);
    }
}
