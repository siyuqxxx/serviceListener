package com.zt.serviceListener.util;

import java.util.Objects;

public class StrUtil {
    public static boolean invalidStr(String str)
    {
        return Objects.isNull(str) || str.isEmpty();
    }
}
