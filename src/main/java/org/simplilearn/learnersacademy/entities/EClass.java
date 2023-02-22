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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.simplilearn.learnersacademy.entities.Student;
import org.simplilearn.learnersacademy.entities.Subject;
import org.simplilearn.learnersacademy.entities.Teacher;

@Entity
public class EClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String cname;
    @OneToMany(mappedBy = "eclass",cascade = CascadeType.ALL)
    private Set<Student> students=new HashSet<>();
    @ManyToMany
    @JoinTable(name = "eclass_subject",joinColumns = @JoinColumn(name="cid"),inverseJoinColumns = @JoinColumn(name="subid"))
    private Set<Subject> subjects=new HashSet<>();
    @ManyToMany
    @JoinTable(name = "eclass_teacher",joinColumns = @JoinColumn(name="cid"),inverseJoinColumns = @JoinColumn(name="tid"))
    private List<Teacher> teachers =new ArrayList<>();


    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    public Set<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
    public List<Teacher> getTeachers() {
        return teachers;
    }
    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(Student student) {
        students.remove(student);
    }
}
