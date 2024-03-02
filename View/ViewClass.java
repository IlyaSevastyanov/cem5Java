package View;

import Controller.Interface.iGetView;
import Model.Domain.Student;
import java.util.List;
import java.util.Scanner;


public class ViewClass implements iGetView {

    public void printAllStudent(List<Student> students) { // Вывод всех студентов
        System.out.println("-----Список Студентов-----");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("--------------------------");
    }

    public String prompt(String msg) { // Получение команды
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.next();
    }

}