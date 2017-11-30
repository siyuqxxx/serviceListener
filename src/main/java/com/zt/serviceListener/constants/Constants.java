package com.zt.serviceListener.constants;

import java.io.File;

public final class Constants {
    public static final String CONF_DIR = System.getProperty("user.dir") + File.separator + "conf" + File.separator;

    public static class PropertiesFile {
        public static final String LOG4J = CONF_DIR + "log4j.properties";
    }

    public static class JsonFile {
        public static final String LIS_SERVER = "lis_server.json";
    }
}
