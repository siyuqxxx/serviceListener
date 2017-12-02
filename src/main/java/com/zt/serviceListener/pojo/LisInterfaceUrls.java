package com.zt.serviceListener.pojo;

import java.util.Arrays;

public class LisInterfaceUrls {
    private LisInterfaceUrl[] urls = new LisInterfaceUrl[]{};

    public LisInterfaceUrl[] getUrls() {
        return urls;
    }

    public void setUrls(LisInterfaceUrl[] urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "LisInterfaceUrls{" +
                "urls=" + Arrays.toString(urls) +
                '}';
    }
}
