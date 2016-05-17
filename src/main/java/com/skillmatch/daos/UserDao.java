package com.skillmatch.daos;

import com.skillmatch.pojos.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by agermenos on 5/16/16.
 */
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void create (User user){
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    public List<User> read (User user){
        return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Example.create(user)).list();
    }

    @Transactional
    public void update(User user){
        sessionFactory.getCurrentSession().update(user);
    }

    @Transactional
    public void delete(User user){
        sessionFactory.getCurrentSession().delete(user);
    }
}
