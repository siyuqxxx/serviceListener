package com.zt.serviceListener.bean;

import com.zt.serviceListener.pojo.LisInterfaceUrl;
import com.zt.serviceListener.util.StrUtil;

import java.util.Objects;

public class LisInterfaceUrlBean implements IBean<LisInterfaceUrl, LisInterfaceUrlBean>, IEnable {
    private LisInterfaceUrl lisInterfaceUrl = new LisInterfaceUrl();

    public LisInterfaceUrlBean(){}

    public LisInterfaceUrlBean(LisInterfaceUrl e) {
        addAll(e);
    }

    public String toUrl() {
        String url = StrUtil.toValid(lisInterfaceUrl.getLisInterfaceUrl());
        return url.startsWith("/") ? url : "/" + url;
    }

    @Override
    public LisInterfaceUrlBean addAll(LisInterfaceUrl e) {
        if (Objects.nonNull(e)) {
            this.lisInterfaceUrl = e;
        }
        return this;
    }

    @Override
    public LisInterfaceUrl toPojo() {
        return this.lisInterfaceUrl;
    }

    @Override
    public void clean() {
        this.lisInterfaceUrl = new LisInterfaceUrl();
    }

    @Override
    public boolean isEnable()
    {
        return lisInterfaceUrl.isEnable();
    }

    @Override
    public String toString() {
        return "LisInterfaceUrlBean{" +
                "lisInterfaceUrl=" + lisInterfaceUrl +
                '}';
    }
}
