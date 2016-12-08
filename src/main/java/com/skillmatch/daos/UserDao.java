package com.skillmatch.daos;

import com.skillmatch.pojos.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by agermenos on 5/16/16.
 */
@Repository("userDao")
public class UserDao extends GeneralDao<User> {
    @Transactional
    public User getUserById(Integer id){
        Query q=sessionFactory.getCurrentSession().createQuery("FROM User WHERE id = :id");
        q.setParameter("id", id);
        return (User)q.uniqueResult();
    }
}
