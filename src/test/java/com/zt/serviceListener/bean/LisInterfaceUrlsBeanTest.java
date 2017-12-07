package com.zt.serviceListener.bean;

import com.zt.serviceListener.pojo.LisInterfaceUrl;
import com.zt.serviceListener.pojo.LisInterfaceUrls;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class LisInterfaceUrlsBeanTest {
    @Test
    public void getRandomUrlInterface() throws Exception {
        LisInterfaceUrl u1 = new LisInterfaceUrl();
        u1.setDescription("test1");
        u1.setLisInterfaceUrl("/test/urt/bookinfo/title/java");

        LisInterfaceUrl u2 = new LisInterfaceUrl();
        u2.setDescription("test2");
        u2.setLisInterfaceUrl("/test/urt/bookinfo/title/c");

        LisInterfaceUrl u3 = new LisInterfaceUrl();
        u3.setDescription("test3");
        u3.setLisInterfaceUrl("/test/urt/bookinfo/title/think");


        Set<LisInterfaceUrl> arr = new HashSet<>();
        arr.add(u1);
        arr.add(u2);
        arr.add(u3);

        LisInterfaceUrls urls = new LisInterfaceUrls();
        urls.setUrls(arr);

        LisInterfaceUrlsBean bean = new LisInterfaceUrlsBean().addAll(urls);

        Set<String> set = arr.stream().map(LisInterfaceUrl::getLisInterfaceUrl).collect(Collectors.toSet());

        for (int i = 0; i < 50; i++) {
            String url = bean.getRandomUrlInterface().toUrl();

            assertTrue(set.contains(url));
        }
    }

}