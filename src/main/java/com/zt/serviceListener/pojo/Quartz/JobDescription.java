package com.zt.serviceListener.pojo.Quartz;

import org.quartz.Job;

public class JobDescription<T extends Job> {
    private String name = "";
    private String group = "";
    private Class<T> jobClazz = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Class<T> getJobClazz() {
        return jobClazz;
    }

    public void setJobClazz(Class<T> jobClazz) {
        this.jobClazz = jobClazz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobDescription<?> that = (JobDescription<?>) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        return jobClazz != null ? jobClazz.equals(that.jobClazz) : that.jobClazz == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (jobClazz != null ? jobClazz.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JobDescription{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", jobClazz=" + jobClazz +
                '}';
    }
}
