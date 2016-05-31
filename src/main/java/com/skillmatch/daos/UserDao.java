package com.skillmatch.daos;

import com.skillmatch.pojos.User;
import org.springframework.stereotype.Repository;

/**
 * Created by agermenos on 5/16/16.
 */
@Repository("userDao")
public class UserDao extends GeneralDao<User> {

}
