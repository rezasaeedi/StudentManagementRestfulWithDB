package com.example.testdatabase.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String stuID;
    private int age;

    protected Student() {}

    public Student(String name, int age, String stuID) {
        this.name = name;
        this.age = age;
        this.stuID = stuID;
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
}
