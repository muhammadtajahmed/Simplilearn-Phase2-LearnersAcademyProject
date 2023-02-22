package org.simplilearn.learnersacademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.simplilearn.learnersacademy.config.HibConfig;
import org.simplilearn.learnersacademy.dao.UserDao;
import org.simplilearn.learnersacademy.entities.User;

public class UserDaoImpl implements UserDao {
    SessionFactory factory= HibConfig.getSessionFactory();
    @Override
    public void saveUser(User user) {
        Session session=factory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(user);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            session.close();
        }

    }

    @Override
    public boolean getUser(String username, String password) {
        boolean userexists=false;
        Session session=factory.openSession();
        Query<User> query1=session.createQuery("from org.simplilearn.learnersacademy.entities.User ");
        List<User> users=query1.getResultList();
        for (User user:users)
        {
            if(username.equals(user.getUsername()))
            {
                if(password.equals(user.getPassword()))
                    userexists=true;
            }
        }
        return userexists;


    }



}

