package org.simplilearn.learnersacademy.services;

import org.simplilearn.learnersacademy.dao.*;
import org.simplilearn.learnersacademy.entities.EClass;
import org.simplilearn.learnersacademy.entities.Student;
import org.simplilearn.learnersacademy.entities.Subject;
import org.simplilearn.learnersacademy.entities.Teacher;

public class SaveService {

    Student student=new Student();

    StudentDao dao=new StudentDaoImpl();

    Subject subject=new Subject();

    SubjectDao dao1=new SubjectDaoImpl();

    EClass eclass=new EClass();

    EClassDao dao2=new EClassDaoImpl();

    Teacher teacher=new Teacher();

    TeacherDao dao3=new TeacherDaoImpl();

    public void createStudent(int rollno,String sname){
        student.setRollno(rollno);
        student.setSname(sname);
        
        dao.saveStudent(student);
    }

    public void createSubject(String sid,String sname){
        subject.setSubid(sid);
        subject.setSubname(sname);
        dao1.saveSubject(subject);
    }

    public void createClass(String cname){
        eclass.setCname(cname);
        dao2.saveClass(eclass);
    }

    public void createTeacher(String tname,int age){
        teacher.setTname(tname);
        teacher.setAge(age);
        dao3.saveTeacher(teacher);
    }
}
