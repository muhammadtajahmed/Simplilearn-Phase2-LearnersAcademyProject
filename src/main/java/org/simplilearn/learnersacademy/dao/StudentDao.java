package org.simplilearn.learnersacademy.dao;

import org.simplilearn.learnersacademy.entities.Student;

public interface StudentDao {
    void saveStudent(Student student);
    Student getStudent(int sid);

}
