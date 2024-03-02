package Controller.Interface;

import Model.Domain.Student;
import java.util.List;

public interface iGetView { // Интерфейс нужен для класса ViewClass
   void printAllStudent(List<Student> students);
     String prompt(String msg);
}