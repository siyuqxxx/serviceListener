package com.zt.serviceListener.pojo;

import java.util.HashSet;
import java.util.Set;

public class LisInterfaceUrls {
    private Set<LisInterfaceUrl> urlSet = new HashSet<LisInterfaceUrl>();

    public Set<LisInterfaceUrl> getUrlSet() {
        return urlSet;
    }

    public void setUrlSet(Set<LisInterfaceUrl> urlSet) {
        this.urlSet = urlSet;
    }

    @Override
    public String toString() {
        return "LisInterfaceUrls{" +
                "urlSet=" + urlSet +
                '}';
    }
}
