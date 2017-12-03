package com.zt.serviceListener.util;

import java.util.Arrays;
import java.util.Objects;

public class ArraysUtil {
    public static <T> T[] concat(T[] first, T[] second) {
        if (Objects.isNull(first) && Objects.isNull(second)) {
            return null;
        }

        if (isInvalid(first)) {
            return second;
        }

        if (isInvalid(second)) {
            return first;
        }

        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static <T> boolean isInvalid(T[] arr) {
        return Objects.isNull(arr) || isEmpty(arr);
    }

    public static <T> boolean isEmpty(T[] arr) {
        return arr.length == 0;
    }
}
