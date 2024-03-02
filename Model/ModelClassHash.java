package Model;

import Controller.Interface.iGetModel;
import Model.Domain.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 * Класс ModelClassHash реализует интерфейс iGetModel для работы с данными студентов в виде хэш-карты.
 */
public class ModelClassHash implements iGetModel {
    private Map<Integer, Student> map; // Хэш-карта для хранения студентов

    /**
     * Конструктор класса, инициализирующий хэш-карту студентов.
     * @param students Список студентов для инициализации хэш-карты.
     */
    public ModelClassHash(List<Student> students) {
        this.map = new HashMap<>();
        for (Student s : students) {
            this.map.put(s.getId(), s);
        }
    }

    /**
     * Получает список всех студентов из хэш-карты.
     * @return Список всех студентов.
     */
    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        for (Student student : map.values()) {
            students.add(student);
        }
        return students;
    }

    /**
     * Удаляет студента из хэш-карты по его идентификатору.
     * @param num Идентификатор студента для удаления.
     */
    @Override
    public void removeFromList(int num) {
        if (map.containsKey(num)) {
            map.remove(num);
        } else {
            System.out.println("Такого студента нет!");
        }
    }
}