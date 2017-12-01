package com.zt.serviceListener.pojo;

import java.util.Arrays;

public class UrlRouting {
    private String[] urls = new String[]{};

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "UrlRouting{" +
                "urls=" + Arrays.toString(urls) +
                '}';
    }
}
