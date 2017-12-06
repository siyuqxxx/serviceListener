package com.zt.serviceListener.model;

import com.zt.serviceListener.pojo.LisInterfaceUrl;
import com.zt.serviceListener.pojo.LisInterfaceUrls;
import com.zt.serviceListener.util.ArraysUtil;
import com.zt.serviceListener.util.RandomUtil;

import java.util.Arrays;
import java.util.Objects;

public class LisInterfaceUrlsBean implements IBean<LisInterfaceUrls, LisInterfaceUrlsBean> {
    private LisInterfaceUrls lisInterfaceUrls = new LisInterfaceUrls();

    @Override
    public LisInterfaceUrlsBean addAll(LisInterfaceUrls urls) {
        if (Objects.nonNull(urls)) {
            addAll(urls.getUrls());
        }
        return this;
    }

    public LisInterfaceUrlsBean addAll(LisInterfaceUrl[] urls) {
        if (Objects.nonNull(urls)) {
            LisInterfaceUrl[] concatUrls = ArraysUtil.concat(lisInterfaceUrls.getUrls(), urls);
            if (!ArraysUtil.isInvalid(concatUrls)) {
                LisInterfaceUrl[] arr = Arrays.stream(concatUrls)
                        .filter(LisInterfaceUrl::isEnable).toArray(LisInterfaceUrl[]::new);
                lisInterfaceUrls.setUrls(arr);
            }
        }
        return this;
    }

    public LisInterfaceUrlsBean filterDisable() {
        LisInterfaceUrlsBean b = new LisInterfaceUrlsBean();
        if (!isEmpty()) {
            LisInterfaceUrl[] arr = Arrays.stream(lisInterfaceUrls.getUrls())
                    .filter(LisInterfaceUrl::isEnable).toArray(LisInterfaceUrl[]::new);
            b.addAll(arr);
        }
        return b;
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

    @Override
    public LisInterfaceUrls toPojo() {
        return lisInterfaceUrls;
    }

    @Override
    public void clean() {
        this.lisInterfaceUrls = new LisInterfaceUrls();
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
