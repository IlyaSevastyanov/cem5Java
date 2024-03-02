package Model;

import java.util.List;
import Controller.Interface.iGetModel;
import Model.Domain.*;

public class ModelClass implements iGetModel {
    private List<Student> students;

    public ModelClass(List<Student> students) {
        this.students = students;
    } // Конструктор

    public List<Student> getAllStudent() {
        return students;
    } // Получение списка

    @Override
    public void removeFromList(int num) { // Удаление студента из списка
        System.out.println("Студент успешно удален из списка!");
        students.remove(num-1);
    }

}