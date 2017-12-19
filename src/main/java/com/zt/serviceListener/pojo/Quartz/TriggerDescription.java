package com.zt.serviceListener.pojo.Quartz;

public class TriggerDescription {
    private String name = "";
    private String group = "";
    private String cron = "";

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

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TriggerDescription that = (TriggerDescription) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        return cron != null ? cron.equals(that.cron) : that.cron == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (cron != null ? cron.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TriggerDescription{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", cron='" + cron + '\'' +
                '}';
    }
}
