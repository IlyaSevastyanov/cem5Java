package Controller;

import Controller.Interface.iGetModel;
import Controller.Interface.iGetView;
import Model.Domain.Student;

import java.util.*;

/**
 * Класс Controller выступает в качестве посредника между классами Model и View,
 * обрабатывая ввод пользователя и обновляя представление соответственно.
 */
public class Controller {
    private iGetModel modelClass;
    private iGetView viewClass;
    private List<Student> students = new ArrayList<>();
    private HashMap<String, iGetView> languageViewMap = new HashMap<>();

    /**
     * Конструктор для инициализации Controller с ссылками на классы Model и View.
     *
     * @param modelClass Класс Model, реализующий интерфейс iGetModel.
     * @param viewClass  Класс View, реализующий интерфейс iGetView.
     */
    public Controller(iGetModel modelClass, iGetView viewClass) {
        this.modelClass = modelClass;
        this.viewClass = viewClass;
    }

    /**
     * Проверяет, содержит ли список студентов какие-либо элементы.
     *
     * @param students Список студентов для проверки.
     * @return true, если список не пустой, false в противном случае.
     */
    private boolean testData(List<Student> students) { // Проверка на наличие элементов в списке
        if (students.size() > 0) return true;
        return false;
    }

    /**
     * Обновляет представление с последними данными о студентах из модели.
     * Вызывается без конкретной команды.
     */
    public void update() { // Запуск без Command
        if (testData(students)) viewClass.printAllStudent(modelClass.getAllStudent());
        else System.out.println("Список пуст!");
        //MVP
    }

    /**
     * Запускает контроллер для обработки команд пользователя.
     * Вызывается с вводом на основе команд.
     */
    public void run() { // Запуск с Command
        Command com = Command.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = viewClass.prompt("Введите команду: ");
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println("Выход из программы!");
                    break;
                case LIST:
                    viewClass.printAllStudent(modelClass.getAllStudent());
                    break;
                case DELETE:
                    Scanner scanner = new Scanner(System.in);
                    int number = scanner.nextInt();
                    try {
                        modelClass.removeFromList(number);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Такого студента нет в списке!");
                    }
            }
        }
    }
}
