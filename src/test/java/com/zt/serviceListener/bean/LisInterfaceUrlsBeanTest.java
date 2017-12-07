package com.zt.serviceListener.bean;

import com.zt.serviceListener.pojo.LisInterfaceUrl;
import com.zt.serviceListener.pojo.LisInterfaceUrls;
import org.junit.Test;

import java.util.Arrays;
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


        LisInterfaceUrl[] arr = new LisInterfaceUrl[3];
        arr[0] = u1;
        arr[1] = u2;
        arr[2] = u3;

        LisInterfaceUrls urls = new LisInterfaceUrls();
        urls.setUrls(arr);

        LisInterfaceUrlsBean bean = new LisInterfaceUrlsBean().addAll(urls);

        Set<String> set = Arrays.stream(arr).map(LisInterfaceUrl::getLisInterfaceUrl).collect(Collectors.toSet());

        for (int i = 0; i < 50; i++) {
            String url = bean.getRandomUrlInterface().toUrl();

            assertTrue(set.contains(url));
        }
    }

}