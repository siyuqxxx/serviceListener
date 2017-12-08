package com.zt.serviceListener.util;

import com.zt.serviceListener.constants.Constants;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {
    public static void write(Properties p, String name) {
        String path = Constants.CONF_DIR + name;

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
                    p.store(s, name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties read(String name) {
        String path = Constants.CONF_DIR + name;
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
}
