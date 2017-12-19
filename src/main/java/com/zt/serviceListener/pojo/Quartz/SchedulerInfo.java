package com.zt.serviceListener.pojo.Quartz;

import java.util.HashSet;
import java.util.Set;

public class SchedulerInfo {
    private JobDescription job = new JobDescription<>();
    private Set<TriggerDescription> triggers = new HashSet<>();
    private boolean isEnable = true;

    public JobDescription getJob() {
        return job;
    }

    public void setJob(JobDescription job) {
        this.job = job;
    }

    public Set<TriggerDescription> getTriggers() {
        return triggers;
    }

    public void setTriggers(Set<TriggerDescription> triggers) {
        this.triggers = triggers;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchedulerInfo that = (SchedulerInfo) o;

        if (job != null ? !job.equals(that.job) : that.job != null) return false;
        return triggers != null ? triggers.equals(that.triggers) : that.triggers == null;
    }

    @Override
    public int hashCode() {
        int result = job != null ? job.hashCode() : 0;
        result = 31 * result + (triggers != null ? triggers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SchedulerInfo{" +
                "job=" + job +
                ", triggers=" + triggers +
                ", isEnable=" + isEnable +
                '}';
    }
}
