package com.evan.wj.service;

import com.evan.wj.dao.UserDAO;
import com.evan.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public Boolean isExist(String username, String password) {
        return !Objects.equals(userDAO.getByUsernameAndPassword(username, password), null);
    }

    public User getUserBynameAndpassword(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public User getUserByname(String username) {
        return userDAO.findByUsername(username);
    }

    public void save(User user) {
        userDAO.save(user);
    }
}
