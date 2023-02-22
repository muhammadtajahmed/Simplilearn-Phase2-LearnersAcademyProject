package org.simplilearn.learnersacademy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.learnersacademy.config.HibConfig;
import org.simplilearn.learnersacademy.dao.StudentDao;
import org.simplilearn.learnersacademy.entities.Student;

public class StudentDaoImpl implements StudentDao {
    SessionFactory factory= HibConfig.getSessionFactory();
    @Override
    public void saveStudent(Student student) {
        Session session=factory.openSession();
        Transaction tx=null;
        try {
            tx= session.beginTransaction();
            session.save(student);
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
    public Student getStudent(int sid) {
        Session session=factory.openSession();
        return session.get(Student.class, sid);
    }


}
