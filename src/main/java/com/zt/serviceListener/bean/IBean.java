package com.zt.serviceListener.bean;

/**
 * @param <T> element
 * @param <K> bean of the element
 */
public interface IBean<T, K> {
    K addAll(T e);

    T toPojo();

    void clean();
}
