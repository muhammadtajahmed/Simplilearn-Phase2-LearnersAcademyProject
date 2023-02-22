package org.simplilearn.learnersacademy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.learnersacademy.config.HibConfig;
import org.simplilearn.learnersacademy.dao.EClassDao;
import org.simplilearn.learnersacademy.entities.EClass;

public class EClassDaoImpl implements EClassDao{
    SessionFactory factory= HibConfig.getSessionFactory();
    @Override
    public void saveClass(EClass eclass) {
        Session session=factory.openSession();
        Transaction tx=null;
        try {
            tx= session.beginTransaction();
            session.save(eclass);
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
    public EClass getClass(int cid) {
        Session session=factory.openSession();
        return session.get(EClass.class, cid);
    }
}
