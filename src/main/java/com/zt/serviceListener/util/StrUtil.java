package com.zt.serviceListener.util;

import java.util.Objects;

public class StrUtil {
    public static boolean invalidStr(String str)
    {
        return Objects.isNull(str) || str.isEmpty();
    }

    public static String toValid(String str)
    {
        return toValid(str, "");
    }

    /**
     * 返回合法的字符串
     *
     * @param str 需要校验的字符串
     * @param defaultStr 默认的字符串
     * @return 如果str，不为空，且trim后也不为空，则返回trim后的str，否则返回 defaultStr （如果 defaultStr 为空，且返回 defaultStr.trim()）
     */
    public static String toValid(String str, String defaultStr)
    {
        String defStr = invalidStr(defaultStr) ? "" : defaultStr.trim();
        return invalidStr(str) ? defStr : str.trim();
    }
}
