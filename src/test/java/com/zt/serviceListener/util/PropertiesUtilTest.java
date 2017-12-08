package com.zt.serviceListener.util;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertEquals;


public class PropertiesUtilTest {
    @Test
    public void PropertiesUtil() throws Exception {
        Properties mail = new Properties();
        mail.setProperty("test", "test");

        String name = "mail.properties";
        PropertiesUtil.write(mail, name);
        Properties read = PropertiesUtil.read(name);

        assertEquals(mail, read);
    }

}