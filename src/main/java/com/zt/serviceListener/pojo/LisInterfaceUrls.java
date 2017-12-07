package com.zt.serviceListener.pojo;

import java.util.HashSet;
import java.util.Set;

public class LisInterfaceUrls {
    private Set<LisInterfaceUrl> urls = new HashSet<LisInterfaceUrl>();

    public Set<LisInterfaceUrl> getUrls() {
        return urls;
    }

    public void setUrls(Set<LisInterfaceUrl> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "LisInterfaceUrls{" +
                "urls=" + urls +
                '}';
    }
}
