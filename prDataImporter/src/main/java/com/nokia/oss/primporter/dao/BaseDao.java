package com.nokia.oss.primporter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ruizhao on 2016/5/23.
 */
@Repository
public class BaseDao<T> implements IBaseDao<T>{
    @Autowired
    private SessionFactory sessionFactory;
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void insert(T t) {
        this.getSession().save(t);
    }
    @Override
    public void alter(T t) {
        this.getSession().update(t);
    }
    @Override
    public void insertOrAlter(T t) {
        this.getSession().saveOrUpdate(t);
    }
    @Override
    public T get(T t) {
        return null;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
