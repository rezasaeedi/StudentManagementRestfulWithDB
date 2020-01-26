package com.example.testdatabase.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String stuID;
    private int age;

    @ManyToOne(optional = false)
    @JoinColumn(name = "school_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private School school;

    /*
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "stu_less",
            joinColumns = { @JoinColumn(name = "stu_ID") },
            inverseJoinColumns = { @JoinColumn(name = "lesson_id") })
    private Set<Lesson> less = new HashSet<>();
    */

    protected Student() {}

    public Student(String name, int age, String stuID, School school) {
        this.name = name;
        this.age = age;
        this.stuID = stuID;
        this.school = school;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, Name='%s', Age=%d, , Age='%s']",
                id, name, age, stuID);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStuID() {
        return stuID;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setStuID(String stuID){
        this.stuID = stuID;
    }

    public void setAge(int age){
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
