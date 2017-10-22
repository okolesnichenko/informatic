package com.company;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Informatic {
    private static ArrayList<Group> groups = new ArrayList<Group>();
    private static Scanner scanner = new Scanner(System.in);
    private static int kurs;
    private static int numberOfGroup;

    public void AddGroup() {
        System.out.print("Введите номер курса: ");
        kurs = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите номер группы: ");
        numberOfGroup = Integer.parseInt(scanner.nextLine());
        ArrayList<Student> students = new ArrayList<Student>();
        Group newGroup = new Group(students, kurs, numberOfGroup);
        groups.add(newGroup);//добавление в лист групп
        ReWrite();
    }

    public void AddStudent() {
        Boolean check = false;
        System.out.print("Введите номер курса добавляемого студента: ");
        kurs = Integer.parseInt(scanner.nextLine());
        String[] marks = {" ", " ", " "};
        System.out.print("Введите номер группы добавляемого студента: ");
        numberOfGroup = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < groups.size(); i++) {
            if ((groups.get(i).getKurs() == kurs) && (groups.get(i).getNumber() == numberOfGroup)) {
                System.out.print("Введите имя добавляемого студента: ");
                String name = scanner.nextLine();
                System.out.print("Введите фамилию добавляемого студента: ");
                String surname = scanner.nextLine();
                Student newStudent = new Student(marks, name, surname);
                groups.get(i).getStudents().add(newStudent);
                check = true;
            }
        }
        if (check) {
            System.out.println("Успешно добавлен");
        } else {
            System.out.println("Не добавлен");
        }
        ReWrite();
    }

    public void RemoveGroup() {
        Boolean check = false;
        System.out.print("Введите курс группы которую вы хотите удалить: ");
        kurs = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите номер группы которую вы хотите удалить: ");
        numberOfGroup = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < groups.size(); i++) {
            if ((groups.get(i).getKurs() == kurs) && (groups.get(i).getNumber() == numberOfGroup)) {
                groups.remove(i);
                check = true;
            }
        }
        if (check) {
            System.out.println("Успешно удалена");
        } else {
            System.out.println("Не удалена");
        }
        ReWrite();
    }

    public void RemoveStudent() {
        Boolean check = false;
        System.out.print("Введите курс студента которого вы хотите удалить: ");
        kurs = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите номер группы студента которого вы хотите удалить: ");
        numberOfGroup = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < groups.size(); i++) {
            if ((groups.get(i).getKurs() == kurs) && (groups.get(i).getNumber() == numberOfGroup)) {
                System.out.print("Введите имя студента которого вы хотите удалить: ");
                String name = scanner.nextLine();
                System.out.print("Введите Фамилию студента которого вы хотите удалить: ");
                String surname = scanner.nextLine();
                for (int j = 0; j < groups.get(i).getStudents().size(); j++) {
                    if ((groups.get(i).getStudents().get(j).getName().equals(name)) && (groups.get(i).getStudents().get(j).getSurname().equals(surname))) {
                        groups.get(i).getStudents().remove(j);
                        check = true;
                    }
                }
            }
        }
        if (check) {
            System.out.println("Успешно удален");
        } else {
            System.out.println("Не удален");
        }
        ReWrite();
    }

    public void ChangeMarks() {
        Boolean check = false;
        System.out.print("Введите курс студента которому надо выставить оценку: ");
        kurs = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите номер группы студента которому надо выставить оценку: ");
        numberOfGroup = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < groups.size(); i++) {
            if ((groups.get(i).getKurs() == kurs) && (groups.get(i).getNumber() == numberOfGroup)) {
                System.out.print("Введите имя студента которому надо выставить оценку: ");
                String name = scanner.nextLine();
                System.out.print("Введите Фамилию студента которому надо выставить оценку: ");
                String surname = scanner.nextLine();
                for (int j = 0; j < groups.get(i).getStudents().size(); j++) {
                    if ((groups.get(i).getStudents().get(j).getName().equals(name)) && (groups.get(i).getStudents().get(j).getSurname().equals(surname))) {
                        System.out.print("Введите номер работы за которую надо выставить оценку: ");
                        int number = Integer.parseInt(scanner.nextLine());
                        if (number - 1 < 3) {
                            System.out.print("Введите оценку: ");
                            groups.get(i).getStudents().get(j).getMarks()[number - 1] = scanner.nextLine();
                            check = true;
                        }
                    }
                }
            }

        }
        if (check) {
            System.out.println("Успешно добавлена");
        } else {
            System.out.println("Не добавлена");
        }
        ReWrite();
    }

    public void ShowAll() {
        for (int i = 0; i < groups.size(); i++) {
            System.out.print("Курс " + groups.get(i).getKurs() + " Группа " + groups.get(i).getNumber() + "\n");
            for (int j = 0; j < groups.get(i).getStudents().size(); j++) {
                System.out.print("\t" + groups.get(i).getStudents().get(j).getSurname() + " " +
                        groups.get(i).getStudents().get(j).getName() + " " + groups.get(i).getStudents().get(j).getMarks()[0] +
                        " " + groups.get(i).getStudents().get(j).getMarks()[1] + " " + groups.get(i).getStudents().get(j).getMarks()[2] +
                        "\n");
            }
        }
    }

    public static void ReWrite() {
        try (FileWriter writer = new FileWriter("informatic.txt", false)) {
            for (int i = 0; i < groups.size(); i++) {
                writer.write("Курс " + groups.get(i).getKurs() + " Группа " + groups.get(i).getNumber() + "\n");
                for (int j = 0; j < groups.get(i).getStudents().size(); j++) {
                    writer.write("\t" + groups.get(i).getStudents().get(j).getSurname() + " " +
                            groups.get(i).getStudents().get(j).getName() + " " + groups.get(i).getStudents().get(j).getMarks()[0] +
                            " " + groups.get(i).getStudents().get(j).getMarks()[1] + " " + groups.get(i).getStudents().get(j).getMarks()[2] +
                            "\n");
                }
                writer.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}