package com.zt.serviceListener.dao;

public interface IDao<T> {
    T read(String path);

    void write(String path, T obj);
}
