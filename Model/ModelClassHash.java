package Model;

import Controller.Interface.iGetModel;
import Model.Domain.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ModelClassHash implements iGetModel {
    Map<Integer, Student> map = new HashMap<>();

    public ModelClassHash(List<Student> students) { // Конструктор
        this.map = new HashMap<>();
        for (Student s : students) this.map.put(s.getId(), s);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            students.add(map.get(i));
        }
        return students;
    }

    @Override
    public void removeFromList(int num) { // Удаление студента
        if(map.containsKey(num)) map.remove(num);
        else System.out.println("Такого студента нет!");
    }

}