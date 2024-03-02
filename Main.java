import Controller.Controller;
import Controller.Interface.iGetModel;
import Controller.Interface.iGetView;
import Model.Domain.*;
import Model.FileModelClass;
import Model.ModelClass;
import View.ViewClass;
import java.util.List;
import java.util.ArrayList;

/**
 * Основной класс программы
 */

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Igor", 22);
        Student student2 = new Student("Nastya", 20);
        Student student3 = new Student("Kolya", 21);
        Student student4 = new Student("Emma ", 24);
        Student student5 = new Student("Sirena", 25);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        FileModelClass fmClass = new FileModelClass("Students.csv");
        fmClass.saveAllStudentToFile(students);
        iGetView view = new ViewClass();
        iGetModel model = new ModelClass(students);
        Controller controller = new Controller(model, view);
        controller.run();

    }
}