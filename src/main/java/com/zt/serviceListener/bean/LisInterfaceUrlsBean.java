package com.zt.serviceListener.bean;

import com.zt.serviceListener.pojo.LisInterfaceUrl;
import com.zt.serviceListener.pojo.LisInterfaceUrls;
import com.zt.serviceListener.util.RandomUtil;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LisInterfaceUrlsBean implements IBean<LisInterfaceUrls, LisInterfaceUrlsBean> {

    private Set<LisInterfaceUrlBean> urlBeans = new HashSet<>();

    public LisInterfaceUrlsBean removeDisable() {
        LisInterfaceUrlsBean b = new LisInterfaceUrlsBean();
        b.setUrlBeans(urlBeans.stream().filter(LisInterfaceUrlBean::isEnable)
                .collect(Collectors.toSet()));
        return b;
    }

    public LisInterfaceUrlBean getRandomUrlInterface() {
        return urlBeans.isEmpty() ? new LisInterfaceUrlBean()
                : new LisInterfaceUrlBean().addAll(getRandomUrl());
    }

    public void setUrlBeans(Set<LisInterfaceUrlBean> urlBeans) {
        this.urlBeans.addAll(urlBeans);
    }

    @Override
    public LisInterfaceUrlsBean addAll(LisInterfaceUrls urls) {
        if (Objects.nonNull(urls)) {
            Set<LisInterfaceUrl> urlsSet = urls.getUrlSet();
            if (Objects.nonNull(urlsSet)) {
                urlBeans.addAll(urlsSet.stream().map(LisInterfaceUrlBean::new).collect(Collectors.toSet()));
            }
        }
        return this;
    }

    @Override
    public LisInterfaceUrls toPojo() {
        LisInterfaceUrls urls = new LisInterfaceUrls();
        urls.setUrlSet(urlBeans.stream().map(LisInterfaceUrlBean::toPojo).collect(Collectors.toSet()));
        return urls;
    }

    @Override
    public void clean() {
        this.urlBeans.clear();
    }

    @Override
    public String toString() {
        return "LisInterfaceUrlsBean{" +
                "urlBeans=" + urlBeans +
                '}';
    }

    private LisInterfaceUrl getRandomUrl() {
        int index = RandomUtil.nextInt(urlBeans.size());
        return index >= 0 ? urlBeans.toArray(new LisInterfaceUrlBean[0])[index].toPojo()
                : new LisInterfaceUrl();
    }
}
