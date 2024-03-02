import Controller.Controller;
import Controller.Interface.iGetModel;
import Controller.Interface.iGetView;
import Model.Domain.*;
import Model.FileModelClass;
import Model.ModelClass;
import View.ViewClass;
import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // Создание экземпляров
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Ivan", 20);
        Student student2 = new Student("Nik", 22);
        Student student3 = new Student("Nikolas", 19);
        Student student4 = new Student("Artem", 19);
        Student student5 = new Student("Bro", 18);
        Student student6 = new Student("Olga", 18);
        Student student7 = new Student("Dima", 18);
        Student student8 = new Student("Tomi", 23);
        Student student9 = new Student("Ryan Gosling", 24);
        Student student10 = new Student("Brother", 25);

        // Добавление всех студентов в 1 список
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        students.add(student10);

        FileModelClass fmClass = new FileModelClass("StudentDB.csv");
        fmClass.saveAllStudentToFile(students);

        iGetView view = new ViewClass();
        iGetModel model = new ModelClass(students);

        Controller controller = new Controller(model, view);

        controller.run();

    }
}