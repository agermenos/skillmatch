package com.skillmatch.daos;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by agermenos on 5/30/16.
 */
public abstract class GeneralDao<T> {
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void create (T t){
        //sessionFactory.getCurrentSession().getTransaction().begin();
        sessionFactory.getCurrentSession().save(t);
        //sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Transactional (readOnly = true)
    public List<T> read (T t){
        return (List<T>) sessionFactory.getCurrentSession().createCriteria(t.getClass())
                .add(Example.create(t)).list();
    }

    @Transactional (readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void update(T t){
        sessionFactory.getCurrentSession().update(t);
    }

    @Transactional (readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(T t){
        sessionFactory.getCurrentSession().delete(t);
    }
}
