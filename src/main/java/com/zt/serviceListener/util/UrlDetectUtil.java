package com.zt.serviceListener.util;

import com.zt.serviceListener.App;
import com.zt.serviceListener.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class UrlDetectUtil {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static String callUrl(String url)
    {
        return callUrl(urlBuild(url));
    }

    public static String callUrl(URL url) {
        LOG.info("call url: " + url);
        if (Objects.nonNull(url)) {
            try {
                return callUrlImpl(url);
            } catch (IOException e) {
                LOG.error("call url error.", e);
                return "call url error.";
            }
        }
        LOG.warn("url is null.");
        return "";
    }

    private static URL urlBuild(String url) {
        try {
            return new URL(StrUtil.toValid(url));
        } catch (MalformedURLException e) {
            LOG.warn("invalid url string.", e);
            e.printStackTrace();
            return null;
        }
    }

    private static String callUrlImpl(URL url) throws IOException {
        StringBuilder b = new StringBuilder();
        try (InputStream inputStream = url.openStream()) {
            Scanner s = new Scanner(inputStream);
            while (s.hasNext()) {
                if (b.length() < Constants.MAX_URL_RESPONSE_LENGTH) {
                    b.append(s.next());
                } else {
                    LOG.warn("url response is over max length. response msg: " + b.toString());
                    break;
                }
            }
            LOG.debug(b.toString());
            return b.toString();
        }
    }
}
