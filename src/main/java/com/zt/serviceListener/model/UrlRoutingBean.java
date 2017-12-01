package com.zt.serviceListener.model;

import com.zt.serviceListener.pojo.UrlRouting;
import com.zt.serviceListener.util.RandomUtil;

public class UrlRoutingBean extends UrlRouting {
    public String getRandomUrlRouting() {
        if (isEmpty()) {
            return "";
        } else if (size() == 1) {
            return super.getUrls()[0];
        } else {
            return getRandomUrl();
        }
    }

    public int size() {
        return super.getUrls().length;
    }

    public boolean isEmpty() {
        return size() > 0;
    }

    private String getRandomUrl() {
        int index = RandomUtil.nextInt(size());
        if (index > 0) {
            return super.getUrls()[index];
        } else {
            return "";
        }
    }
}
