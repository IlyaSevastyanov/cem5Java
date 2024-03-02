package Controller.Interface;
import Model.Domain.Student;
import java.util.List;


public interface iGetModel { // Интерфейс нужен для ModelClass
    public List<Student> getAllStudent();
    public void removeFromList(int num);
}