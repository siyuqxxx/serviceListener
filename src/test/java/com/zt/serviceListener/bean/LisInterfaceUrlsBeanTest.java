package com.zt.serviceListener.bean;

import com.zt.serviceListener.TestUtil;
import com.zt.serviceListener.pojo.LisInterfaceUrl;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class LisInterfaceUrlsBeanTest {
    @Test
    public void getRandomUrlInterface() throws Exception {
        LisInterfaceUrlsBean bean = TestUtil.CreateLisInterfaceUrl.urlsbean();

        Set<LisInterfaceUrl> except = TestUtil.CreateLisInterfaceUrl.urlSet();

        Set<String> set = except.stream().map(LisInterfaceUrl::getLisInterfaceUrl).collect(Collectors.toSet());

        for (int i = 0; i < 50; i++) {
            String url = bean.getRandomUrlInterface().toUrl();

            assertTrue(set.contains(url));
        }
    }

}