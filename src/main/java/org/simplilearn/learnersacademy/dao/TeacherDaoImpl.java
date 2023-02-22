package org.simplilearn.learnersacademy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.learnersacademy.config.HibConfig;
import org.simplilearn.learnersacademy.dao.TeacherDao;
import org.simplilearn.learnersacademy.entities.Teacher;

public class TeacherDaoImpl implements TeacherDao{
    SessionFactory factory= HibConfig.getSessionFactory();
    @Override
    public void saveTeacher(Teacher teacher) {
        Session session=factory.openSession();
        Transaction tx=null;
        try {
            tx= session.beginTransaction();
            session.save(teacher);
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
    public Teacher getTeacher(int tid) {
        Session session=factory.openSession();
        return session.get(Teacher.class, tid);
    }
}
