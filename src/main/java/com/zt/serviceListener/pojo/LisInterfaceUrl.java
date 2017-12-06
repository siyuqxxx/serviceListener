package com.zt.serviceListener.pojo;

public class LisInterfaceUrl {
    private String description = "";
    private String LisInterfaceUrl = "";
    private boolean isEnable = true;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLisInterfaceUrl() {
        return LisInterfaceUrl;
    }

    public void setLisInterfaceUrl(String lisInterfaceUrl) {
        this.LisInterfaceUrl = lisInterfaceUrl;
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

        LisInterfaceUrl that = (LisInterfaceUrl) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return LisInterfaceUrl != null ? LisInterfaceUrl.equals(that.LisInterfaceUrl) : that.LisInterfaceUrl == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (LisInterfaceUrl != null ? LisInterfaceUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LisInterfaceUrl{" +
                "description='" + description + '\'' +
                ", LisInterfaceUrl='" + LisInterfaceUrl + '\'' +
                '}';
    }
}
