package Model.Domain;
/**
 * Класс Student
 * Представляет собой структуру для создания объектов типа "Student" с идентификатором студентов и генератором id
 */
public class Student extends Person implements Comparable<Student> {
    private int id; // Идентификатор студента
    private static int idGenerator; // Генератор id

    /**
     * Конструктор для создания студента с заданным именем и возрастом.
     * Увеличивает генератор id и назначает уникальный id студенту.
     * @param name Имя студента.
     * @param age Возраст студента.
     */
    public Student(String name, int age) {
        super(name, age);
        idGenerator++;
        this.id = idGenerator;
    }

    /**
     * Получить идентификатор студента.
     * @return Идентификатор студента.
     */
    public int getId() {
        return id;
    }

    /**
     * Переопределение метода toString для вывода информации о студенте.
     * @return Строковое представление объекта Student.
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id + ", name: " + super.getName() + ", age: " + super.getAge() + '}';
    }

    /**
     * Сравнивает текущего студента с переданным студентом.
     * Сначала сравнивает возраст, затем идентификаторы, если возрасты равны.
     * @param o Студент для сравнения.
     * @return Результат сравнения.
     */
    @Override
    public int compareTo(Student o) {
        if (this.getAge() > o.getAge()) return 1;
        if (this.getAge() < o.getAge()) return -1;
        if (this.getId() > o.getId()) return 1;
        if (this.getId() < o.getId()) return -1;
        return 0;
    }
}