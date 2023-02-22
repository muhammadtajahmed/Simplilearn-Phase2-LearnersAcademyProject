package org.simplilearn.learnersacademy.services;

import org.simplilearn.learnersacademy.dao.UserDao;
import org.simplilearn.learnersacademy.dao.UserDaoImpl;
import org.simplilearn.learnersacademy.entities.User;

public class UserService {
    User user=new User();
    UserDao dao=new UserDaoImpl();
    public void createUser(String username,String password){
        user.setUsername(username);
        user.setPassword(password);
        dao.saveUser(user);
    }
    public boolean loginUser(String username,String password){
        boolean status=false;
        status=dao.getUser(username, password);
        return status;
    }
}
