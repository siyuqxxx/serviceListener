package com.zt.serviceListener.model;

public interface IBean<T, K> {
    K addAll(T e);

    T toPojo();

    void clean();
}
