package com.zt.serviceListener.model;

import com.zt.serviceListener.pojo.LisInterfaceUrl;
import com.zt.serviceListener.pojo.LisInterfaceUrls;
import com.zt.serviceListener.util.ArraysUtil;
import com.zt.serviceListener.util.RandomUtil;

import java.util.Objects;

public class LisInterfaceUrlsBean extends LisInterfaceUrls {
    public LisInterfaceUrlsBean addAll(LisInterfaceUrls urls)
    {
        LisInterfaceUrl[] concatUrls = ArraysUtil.concat(super.getUrls(), urls.getUrls());
        if (Objects.nonNull(concatUrls)) {
            super.setUrls(concatUrls);
        }
        return this;
    }
    public LisInterfaceUrl getRandomUrlRouting() {
        if (isEmpty()) {
            return new LisInterfaceUrl();
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

    private LisInterfaceUrl getRandomUrl() {
        int index = RandomUtil.nextInt(size());
        if (index > 0) {
            return super.getUrls()[index];
        } else {
            return new LisInterfaceUrl();
        }
    }
}
