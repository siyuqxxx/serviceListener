package com.zt.serviceListener;

import com.zt.serviceListener.constants.Constants;
import com.zt.serviceListener.controller.UrlController;
import com.zt.serviceListener.util.UrlDetectUtil;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Set;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        PropertyConfigurator.configure(Constants.PropertiesFile.LOG4J);

        UrlController urlController = new UrlController();

        Set<String> urlSet = urlController.getUrlSet();

        for (String url : urlSet) {
            String result = UrlDetectUtil.callUrl(url);
            LOG.info(result);
        }
    }
}
