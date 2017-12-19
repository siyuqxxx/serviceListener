package com.zt.serviceListener.pojo.Quartz;

import java.util.HashSet;
import java.util.Set;

public class SchedulerInfos {
    private Set<SchedulerInfo> schedulerInfoSet = new HashSet<>();

    public Set<SchedulerInfo> getSchedulerInfoSet() {
        return schedulerInfoSet;
    }

    public void setSchedulerInfoSet(Set<SchedulerInfo> schedulerInfoSet) {
        this.schedulerInfoSet = schedulerInfoSet;
    }

    @Override
    public String toString() {
        return "SchedulerInfos{" +
                "schedulerInfoSet=" + schedulerInfoSet +
                '}';
    }
}
