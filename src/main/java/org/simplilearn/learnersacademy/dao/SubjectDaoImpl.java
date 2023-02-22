package org.simplilearn.learnersacademy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.learnersacademy.dao.SubjectDao;
import org.simplilearn.learnersacademy.entities.Subject;
import org.simplilearn.learnersacademy.config.HibConfig;
import org.simplilearn.learnersacademy.dao.StudentDao;
import org.simplilearn.learnersacademy.entities.Student;

public class SubjectDaoImpl implements SubjectDao{
    SessionFactory factory= HibConfig.getSessionFactory();
    @Override
    public void saveSubject(Subject subject) {
        Session session=factory.openSession();
        Transaction tx=null;
        try {
            tx= session.beginTransaction();
            session.save(subject);
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            session.close();
        }
    }

    @Override
    public Subject getSubject(int subid) {
        Session session=factory.openSession();
        return session.get(Subject.class , subid);
    }
}
