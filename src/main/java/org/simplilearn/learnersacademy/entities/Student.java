package org.simplilearn.learnersacademy.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.simplilearn.learnersacademy.entities.EClass;

@Entity
public class Student {

    @Id
    private int rollno;
    private String sname;
    @ManyToOne
    @JoinColumn(name = "cid")
    private EClass eclass;

    public int getRollno() {
        return rollno;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public EClass getEclass() {
        return eclass;
    }
    public void setEclass(EClass eclass) {
        this.eclass = eclass;
    }



}
