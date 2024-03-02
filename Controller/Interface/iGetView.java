package Controller.Interface;

import Model.Domain.Student;
import java.util.List;

/**
 * Интерфейс iGetView используется для взаимодействия с пользовательским интерфейсом.
 */
public interface iGetView {
    /**
     * Выводит список всех студентов.
     * @param students Список студентов для вывода.
     */
    void printAllStudent(List<Student> students);

    /**
     * Запрашивает команду у пользователя.
     * @param msg Сообщение с запросом команды.
     * @return Введенная пользователем команда.
     */
    String prompt(String msg);
}