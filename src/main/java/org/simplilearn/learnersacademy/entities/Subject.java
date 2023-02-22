package org.simplilearn.learnersacademy.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.simplilearn.learnersacademy.entities.EClass;
import org.simplilearn.learnersacademy.entities.Teacher;

@Entity
public class Subject {
    @Id
    private String subid;
    private String subname;


    @ManyToMany(mappedBy = "subjects")
    private List<EClass> classes=new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tid")
    private Teacher teacher;
    public String getSubid() {
        return subid;
    }
    public void setSubid(String subid) {
        this.subid = subid;
    }
    public String getSubname() {
        return subname;
    }
    public void setSubname(String subname) {
        this.subname = subname;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<EClass> getClasses() {
        return classes;
    }

    public void setClasses(List<EClass> classes) {
        this.classes = classes;
    }


}
