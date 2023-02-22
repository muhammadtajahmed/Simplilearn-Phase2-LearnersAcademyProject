package org.simplilearn.learnersacademy.dao;

import org.simplilearn.learnersacademy.entities.Teacher;

public interface TeacherDao {
    void saveTeacher(Teacher teacher);
    Teacher getTeacher(int tid);
}
