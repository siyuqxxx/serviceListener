package com.zt.serviceListener.util;

import com.zt.serviceListener.constants.Constants;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class PropertiesUtil {
    private static final String DEFAULT_PROPERTIES_VALUE = "";

    public static void write(Properties p, String file) {
        String path = Constants.CONF_DIR + file;

        if (StrUtil.invalidStr(path)) {
            return;
        }

        System.out.println(path);

        File f = new File(path);

        try {
            if (!f.exists()) {
                if (!f.createNewFile()) {
                    return;
                }
            }

            if (f.isFile()) {
                try (OutputStream s = new FileOutputStream(f)) {
                    p.store(s, file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties read(String path) {
        Properties p = new Properties();

        if (StrUtil.invalidStr(path)) {
            return p;
        }

        System.out.println(path);

        File f = new File(path);

        try {
            if (f.exists() && f.isFile()) {
                try (InputStream s = new FileInputStream(f)) {
                    p.load(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return p;
    }

    public static String getValue(Properties p, String key) {
        return getValue(p, key, DEFAULT_PROPERTIES_VALUE);
    }

    public static String getValue(Properties p, String key, String defaultValue) {
        key = StrUtil.toValid(key);
        defaultValue = StrUtil.toValid(defaultValue);

        return Objects.nonNull(p) && p.containsKey(key) ? p.getProperty(key, defaultValue) : DEFAULT_PROPERTIES_VALUE;
    }

    public static void copy(String key, Properties from, Properties to) {
        copy(key, from, to, DEFAULT_PROPERTIES_VALUE);
    }

    public static void copy(String key, Properties from, Properties to, String defaultValue) {
        if (Objects.nonNull(from) && Objects.nonNull(to)) {
            key = StrUtil.toValid(key);
            defaultValue = StrUtil.toValid(defaultValue);

            String value = from.containsKey(key) ? from.getProperty(key) : defaultValue;
            to.setProperty(key, value);
        }
    }
}
