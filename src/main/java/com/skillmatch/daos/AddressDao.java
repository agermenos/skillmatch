package com.skillmatch.daos;

import com.skillmatch.pojos.Address;
import com.sun.tools.javac.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by agermenos on 5/15/16.
 */
@Repository("addressDao")
public class AddressDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void create (Address address){
        //sessionFactory.getCurrentSession().getTransaction().begin();
        sessionFactory.getCurrentSession().save(address);
        //sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Transactional
    public ArrayList<Address> read (Address address){
       return (ArrayList<Address>) sessionFactory.getCurrentSession().createCriteria(Address.class)
                .add(Example.create(address)).list();
    }

    @Transactional
    public void update(Address address){
        //sessionFactory.getCurrentSession().getTransaction().begin();
        sessionFactory.getCurrentSession().update(address);
        //sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Transactional
    public void delete(Address address){
        //sessionFactory.getCurrentSession().getTransaction().begin();
        sessionFactory.getCurrentSession().delete(address);
        //sessionFactory.getCurrentSession().getTransaction().commit();
    }
}
