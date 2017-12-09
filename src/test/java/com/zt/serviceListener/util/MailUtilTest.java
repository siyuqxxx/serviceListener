package com.zt.serviceListener.util;

import org.junit.Test;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MailUtilTest {
    @Test
    public void testInternetAddress() throws AddressException {
        InternetAddress address = new InternetAddress("qian siyu <siyuqxxx@qq.com>");
        System.out.println(address);
        assertEquals("qian siyu <siyuqxxx@qq.com>", address.toString());

        System.out.println(address.getAddress());
        assertEquals("siyuqxxx@qq.com", address.getAddress());

        System.out.println(address.getPersonal());
        assertEquals("qian siyu", address.getPersonal());
    }

    @Test
    public void testInternetAddressPrase() throws AddressException {
        String addresses = "qian siyu <siyuq@qq.com>, qian siyu <qiansy@beijingtu.com>";
        InternetAddress[] parse = InternetAddress.parse(addresses);
        System.out.println(Arrays.asList(parse));
        assertEquals(2, parse.length);
    }
}