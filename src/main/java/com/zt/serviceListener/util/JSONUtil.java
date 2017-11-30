package com.zt.serviceListener.util;

import com.alibaba.fastjson.JSON;

import java.io.*;

public class JSONUtil {

    public static void obj2JsonFile(String path, Object obj) {
        if (StrUtil.invalidStr(path))
        {
            return ;
        }


        obj2JsonFile(new File(path), obj);
    }

    public static void obj2JsonFile(File f, Object obj) {
        try {
            if (f == null || obj == null) {
                return;
            }

            if (!f.exists()) {
                if (!f.createNewFile()) {
                    return;
                }
            }

            if (f.isFile()) {
                try (FileWriter writer = new FileWriter(f)) {
                    try (BufferedWriter w = new BufferedWriter(writer)) {
                        JSON.writeJSONStringTo(obj, w);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T jsonFile2Obj(String path, Class<T> clazz) {
        if (StrUtil.invalidStr(path))
        {
            return null;
        }


        return jsonFile2Obj(new File(path), clazz);
    }

    public static <T> T jsonFile2Obj(File f, Class<T> clazz) {
        if (clazz == null || f == null) {
            return null;
        }

        if (f.exists() && f.isFile()) {
            try {
                try (FileReader reader = new FileReader(f)) {
                    try (BufferedReader r = new BufferedReader(reader)) {

                        String temp = null;
                        StringBuilder buffer = new StringBuilder();
                        while ((temp = r.readLine()) != null) {
                            buffer.append(temp);
                        }

                        return JSON.parseObject(buffer.toString(), clazz);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
