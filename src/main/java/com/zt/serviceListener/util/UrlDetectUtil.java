package com.zt.serviceListener.util;

import com.zt.serviceListener.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;
import java.util.Scanner;

public class UrlDetectUtil {
    private static final Logger LOG = LoggerFactory.getLogger(UrlDetectUtil.class);

    public static String callUrl(String url) throws IOException {
        return callUrl(urlBuild(url));
    }


    public static String callUrl(URL url) throws IOException {
        if (Objects.isNull(url)) {
            return "";
        }

        URLConnection urlConnection = url.openConnection();
        urlConnection.setConnectTimeout(30000);
        urlConnection.setReadTimeout(30000);
        urlConnection.connect();

        StringBuilder b = new StringBuilder();
        try (InputStream inputStream = urlConnection.getInputStream()) {
            Scanner s = new Scanner(inputStream);
            while (s.hasNext()) {
                if (b.length() < Constants.MAX_URL_RESPONSE_LENGTH) {
                    b.append(s.next());
                } else {
                    LOG.warn("url response is over max length.");
                    LOG.info(String.format("Top %d response msg: %s...", Constants.MAX_URL_RESPONSE_LENGTH, b.toString()));
                    break;
                }
            }
            LOG.debug(b.toString());
            return b.toString();
        }
    }

    private static URL urlBuild(String url) {
        try {
            return new URL(StrUtil.toValid(url));
        } catch (MalformedURLException e) {
            LOG.warn("invalid url string.", e);
            return null;
        }
    }
}
