package com.zt.serviceListener.constants;

import java.io.File;

public final class Constants {
    public static final String BASE_DIR = System.getProperty("user.dir") + File.separator;
    public static final String DEBUG_DIR = BASE_DIR + "src" + File.separator + "main" + File.separator;
    public static final boolean IS_DEBUG = new File(DEBUG_DIR).exists();
    public static final String CONF_DIR = (IS_DEBUG ? DEBUG_DIR : BASE_DIR) + "config" + File.separator;

    public static final String HTTP_HEAD = "http://";

    public static final int MAX_URL_RESPONSE_LENGTH = 1024;

    public static class PropertiesFile {
        public static final String LOG4J = CONF_DIR + "log4j.properties";
        public static final String MAIL = CONF_DIR + "mail.properties";
    }

    public static class JsonFile {
        public static final String LIS_SERVER = CONF_DIR + "lis_servers.json";
        public static final String LIS_INTERFACE = CONF_DIR + "lis_interface_urls.json";
        public static final String MAIL = CONF_DIR + "mail_template.json";
        public static final String SCHEDULES = CONF_DIR + "schedules.json";
    }

    public static class Mail {
        public static final int ERROR_MSG_TEMPLATE = 1;
        public static final String TEXT_PLAIN_UTF8 = "text/plain;charset=utf-8";
        public static final String TEXT_HTML_UTF8 = "text/html;charset=utf-8";
    }

    public enum ConnectStatus {
        SUCCESS, ERROR
    }
}
