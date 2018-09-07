package com.zt.serviceListener.util;

import org.junit.Test;

public class UrlDetectUtilTest {
    @Test
    public void callUrl() throws Exception {

        String s = UrlDetectUtil.callUrl("http://59.76.61.4:8088/datasnap/rest/TInterFace/searchbook/isbn/702004929x");
        System.out.println(s);
    }
}