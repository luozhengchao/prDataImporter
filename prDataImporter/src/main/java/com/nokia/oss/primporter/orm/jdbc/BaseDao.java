package com.nokia.oss.primporter.orm.jdbc;

import com.nokia.oss.primporter.exception.ImporterException;

import java.util.Properties;

/**
 * User: j59chen
 * Date: 2016/5/24
 * Time: 23:05
 * TO-DO: class Description, need to be modified
 */
public interface BaseDao<T> {
     void insert(T entity) throws ImporterException;
    void initialize(Properties properties) throws ImporterException;
}
