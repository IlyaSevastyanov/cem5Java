package View;

import Controller.Interface.iGetView;
import Model.Domain.Student;
import java.util.List;
import java.util.Scanner;
/**
 * Класс ViewClass реализует интерфейс iGetView для взаимодействия с пользователем.
 */
public class ViewClass implements iGetView {

    /**
     * Выводит список всех студентов.
     * @param students Список студентов для вывода.
     */
    public void printAllStudent(List<Student> students) {
        System.out.println("---------------Список Студентов---------------");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("----------------------------------------------------");
    }

    /**
     * Запрашивает команду у пользователя.
     * @param msg Сообщение с запросом команды.
     * @return Введенная пользователем команда.
     */
    public String prompt(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.next();
    }

}