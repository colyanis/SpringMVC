package com.mykola.spring.web.service;

import com.mykola.spring.web.dao.User;
import com.mykola.spring.web.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersService {

    private UsersDao usersDao;

    @Autowired
    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void create(User user) {
        usersDao.create(user);
    }

    public boolean exist(String username) {
        return usersDao.exists(username);
    }
}
