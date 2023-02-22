package org.simplilearn.learnersacademy.dao;

import org.simplilearn.learnersacademy.entities.User;

public interface UserDao {
    void saveUser(User user);
    boolean getUser(String username, String password);
}
