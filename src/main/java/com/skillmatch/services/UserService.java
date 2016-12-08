package com.skillmatch.services;

import com.skillmatch.daos.UserDao;
import com.skillmatch.daos.UserSkillDao;
import com.skillmatch.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by agermenos on 7/6/16.
 */
@Service("userService")
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUser(int userId) {
        return userDao.getUserById(userId);
    }

}
