package com.zt.serviceListener.util;

import java.util.Arrays;
import java.util.Objects;

public class ArraysUtil {
    public static <T> T[] concat(T[] first, T[] second) {
        if (Objects.isNull(first) && Objects.isNull(second))
        {
            return null;
        }

        if (Objects.nonNull(first) && Objects.isNull(second)) {
            return first;
        }

        if (Objects.isNull(first) && Objects.nonNull(second)) {
            return second;
        }

        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static <T> boolean isEmpty(T[] arr)
    {
        return arr.length == 0;
    }
}
