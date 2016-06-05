package com.nokia.oss.primporter.dao;

/**
 * Created by ruizhao on 2016/5/23.
 */
public interface IBaseDao<T> {
    public void insert(T t);
    public void alter(T t);
    public void insertOrAlter(T t);
    public T get(T t);
}
