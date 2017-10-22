package com.company;

import java.util.ArrayList;

public class Student {
    private String name;
    private String surname;
    private String[] marks;

    public Student(String[] marks, String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.marks = marks;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String[] getMarks(){
        return marks;
    }

    public void setMarks(String[] marks){
        this.marks=marks;
    }
}
