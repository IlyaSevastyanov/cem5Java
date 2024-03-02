package Controller.Interface;
import Model.Domain.Student;
import java.util.List;

/**
 * Интерфейс iGetModel используется для взаимодействия с моделью данных студентов.
 */
public interface iGetModel {
    /**
     * Получает список всех студентов.
     * @return Список всех студентов.
     */
    public List<Student> getAllStudent();

    /**
     * Удаляет студента из списка по его номеру идентификатора.
     * @param num Номер идентификатора студента для удаления.
     */
    public void removeFromList(int num);
}