package com.skillmatch.services;

import com.skillmatch.daos.UserDao;
import com.skillmatch.daos.UserSkillDao;
import com.skillmatch.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by agermenos on 7/6/16.
 */
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    UserSkillDao userSkillDao;

    public User getUser(int userId) {
        User user = new User();
        user.setId(userId);
        List<User> users = userDao.read(user);
        assert (users.size()<1 && users.size()>0);


        return users.get(0);
    }
}
