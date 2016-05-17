package com.skillmatch.daos;

import com.skillmatch.pojos.Contact;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by agermenos on 5/16/16.
 */
public class ContactDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void create (Contact contact){
        sessionFactory.getCurrentSession().save(contact);
    }

    @Transactional
    public List<Contact> read (Contact contact){
        return (List<Contact>) sessionFactory.getCurrentSession().createCriteria(Contact.class)
                .add(Example.create(contact)).list();
    }

    @Transactional
    public void update(Contact contact){
        sessionFactory.getCurrentSession().update(contact);
    }

    @Transactional
    public void delete(Contact contact){
        sessionFactory.getCurrentSession().delete(contact);
    }
}
