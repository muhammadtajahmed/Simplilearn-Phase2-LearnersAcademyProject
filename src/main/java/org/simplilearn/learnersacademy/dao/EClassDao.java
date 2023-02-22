package org.simplilearn.learnersacademy.dao;

import org.simplilearn.learnersacademy.entities.EClass;

public interface EClassDao {
    void saveClass(EClass eclass);
    EClass getClass(int cid);
}
