package Model;

import java.util.List;
import Controller.Interface.iGetModel;
import Model.Domain.*;
/**
 * Класс ModelClass реализует интерфейс iGetModel для работы с данными студентов в памяти.
 */
public class ModelClass implements iGetModel {
    private final List<Student> students; // Список студентов

    /**
     * Конструктор класса, инициализирующий список студентов.
     * @param students Список студентов.
     */
    public ModelClass(List<Student> students) {
        this.students = students;
    }

    /**
     * Возвращает список всех студентов.
     * @return Список всех студентов.
     */
    public List<Student> getAllStudent() {
        return students;
    }

    /**
     * Удаляет студента из списка по его номеру идентификатора.
     * @param num Номер идентификатора студента для удаления.
     */
    @Override
    public void removeFromList(int num) {
        System.out.println("Студент успешно удален из списка!");
        students.remove(num - 1);
    }
}