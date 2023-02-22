package org.simplilearn.learnersacademy.dao;

import org.simplilearn.learnersacademy.entities.Subject;

public interface SubjectDao {
    void saveSubject(Subject subject);
    Subject getSubject(int subid);
}
