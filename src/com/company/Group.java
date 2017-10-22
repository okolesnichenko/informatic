package com.company;

import java.util.ArrayList;

public class Group {
    private ArrayList<Student> students;
    private int kurs;
    private int number;

    public Group(ArrayList<Student> students, int kurs, int number) {
        this.students = students;
        this.kurs = kurs;
        this.number = number;
    }

    public int getKurs() {
        return kurs;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students){
        this.students=students;
    }


}
