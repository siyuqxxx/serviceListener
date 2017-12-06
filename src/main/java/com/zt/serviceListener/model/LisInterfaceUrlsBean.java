package com.zt.serviceListener.model;

import com.zt.serviceListener.pojo.LisInterfaceUrl;
import com.zt.serviceListener.pojo.LisInterfaceUrls;
import com.zt.serviceListener.util.ArraysUtil;
import com.zt.serviceListener.util.RandomUtil;

import java.util.Objects;

public class LisInterfaceUrlsBean {
    private LisInterfaceUrls lisInterfaceUrls = new LisInterfaceUrls();

    public LisInterfaceUrlsBean addAll(LisInterfaceUrls urls) {
        if (Objects.nonNull(urls)) {
            LisInterfaceUrl[] concatUrls = ArraysUtil.concat(lisInterfaceUrls.getUrls(), urls.getUrls());
            if (!ArraysUtil.isInvalid(concatUrls)) {
                lisInterfaceUrls.setUrls(concatUrls);
            }
        }
        return this;
    }

    public LisInterfaceUrlBean getRandomUrlInterface() {
        LisInterfaceUrlBean bean = new LisInterfaceUrlBean();
        if (isEmpty()) {
            return bean;
        } else if (size() == 1) {
            return bean.addAll(lisInterfaceUrls.getUrls()[0]);
        } else {
            return bean.addAll(getRandomUrl());
        }
    }

    public int size() {
        return lisInterfaceUrls.getUrls().length;
    }

    public boolean isEmpty() {
        return size() <= 0;
    }

    public LisInterfaceUrls toPojo() {
        return lisInterfaceUrls;
    }

    @Override
    public String toString() {
        return "LisInterfaceUrlsBean{" +
                "lisInterfaceUrls=" + lisInterfaceUrls +
                '}';
    }

    private LisInterfaceUrl getRandomUrl() {
        int index = RandomUtil.nextInt(size());
        if (index >= 0) {
            return lisInterfaceUrls.getUrls()[index];
        } else {
            return new LisInterfaceUrl();
        }
    }
}
