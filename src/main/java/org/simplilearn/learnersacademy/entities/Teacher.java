package org.simplilearn.learnersacademy.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.simplilearn.learnersacademy.entities.EClass;
import org.simplilearn.learnersacademy.entities.Subject;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;
    private String tname;
    private int age;
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    Set<Subject> subjects=new HashSet<>();
    @ManyToMany(mappedBy = "teachers")
    List<EClass> classes=new ArrayList<>();



    public int getTid() {
        return tid;
    }
    public void setTid(int tid) {
        this.tid = tid;
    }
    public String getTname() {
        return tname;
    }
    public void setTname(String tname) {
        this.tname = tname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Set<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
    public List<EClass> getClasses() {
        return classes;
    }
    public void setClasses(List<EClass> classes) {
        this.classes = classes;
    }
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }
    public void addClass(EClass eclass) {
        classes.add(eclass);
    }
    public void removeClass(EClass eclass) {
        classes.remove(eclass);
    }

}
