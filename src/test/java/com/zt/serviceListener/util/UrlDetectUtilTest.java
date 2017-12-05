package com.zt.serviceListener.util;

import org.junit.Test;

public class UrlDetectUtilTest {
    @Test
    public void callUrl() throws Exception {

        String s = UrlDetectUtil.callUrl("http://58.42.228.144:38080/datasnap/rest/TInterFace/searchbook/title/java");
        System.out.println(s);
    }

}