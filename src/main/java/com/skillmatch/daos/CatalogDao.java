package com.skillmatch.daos;

import com.skillmatch.pojos.Catalog;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by agermenos on 5/16/16.
 */
@Repository("catalogDao")
public class CatalogDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void create (Catalog catalog){
        sessionFactory.getCurrentSession().save(catalog);
    }

    @Transactional
    public List<Catalog> read (Catalog catalog){
        return (List<Catalog>) sessionFactory.getCurrentSession().createCriteria(Catalog.class)
                .add(Example.create(catalog)).list();
    }

    @Transactional
    public void update(Catalog catalog){
        sessionFactory.getCurrentSession().update(catalog);
    }

    @Transactional
    public void delete(Catalog catalog){
        sessionFactory.getCurrentSession().delete(catalog);
    }
}
