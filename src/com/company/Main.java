package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Boolean check = true;
        Scanner scanner = new Scanner(System.in);
        Informatic informatic = new Informatic();
        while(check) {
            System.out.println("Добавить группу(0) / Добавить студента(1) / Удалить группу(2) / Удалить студента(3) / " +
                    "Добавить оценку(4) / Показать все(5) / Выход(6)");
            String n = scanner.nextLine();
            switch (n) {
                case ("0"):
                    informatic.AddGroup();
                    break;
                case ("1"):
                    informatic.AddStudent();
                    break;
                case ("2"):
                    informatic.RemoveGroup();
                    break;
                case ("3"):
                    informatic.RemoveStudent();
                    break;
                case ("4"):
                    informatic.ChangeMarks();
                    break;
                case("5"):
                    informatic.ShowAll();
                    break;
                case ("6"):
                    check=false;
                    break;
                default: System.out.println("Неверный символ");
            }
        }
    }
}
