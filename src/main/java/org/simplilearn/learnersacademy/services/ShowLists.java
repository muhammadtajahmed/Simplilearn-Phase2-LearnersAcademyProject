package org.simplilearn.learnersacademy.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.simplilearn.learnersacademy.config.HibConfig;
import org.simplilearn.learnersacademy.entities.EClass;
import org.simplilearn.learnersacademy.entities.Student;
import org.simplilearn.learnersacademy.entities.Subject;
import org.simplilearn.learnersacademy.entities.Teacher;

public class ShowLists {
    SessionFactory factory= HibConfig.getSessionFactory();
    public List<Student> showStudents()
    {
        List<Student> students = null;
        Session session = factory.openSession();
        Query<Student> query = session.createQuery("select s from org.simplilearn.learnersacademy.entities.Student s");
        students = query.getResultList();
        return students;
    }
    public List<Teacher> showTeachers()
    {
        List<Teacher> teachers = null;
        Session session = factory.openSession();
        Query<Teacher> query = session.createQuery("select t from org.simplilearn.learnersacademy.entities.Teacher t");
        teachers=query.getResultList();
        return teachers;
    }
    public List<EClass> showClasses()
    {
        List<EClass> classes = null;
        Session session=factory.openSession();
        Query<EClass> query = session.createQuery("select c from org.simplilearn.learnersacademy.entities.EClass c");
        classes=query.getResultList();
        return classes;
    }
    public List<Subject> showSubjects()
    {
        List<Subject> subjects=null;
        Session session= factory.openSession();
        Query<Subject> query = session.createQuery("select s from org.simplilearn.learnersacademy.entities.Subject s");
        subjects=query.getResultList();
        return subjects;
    }
}
