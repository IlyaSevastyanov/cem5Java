package Model.Domain;

/**
 * Абстрактный класс Person представляет шаблон для классов, подобных Student.
 */
public abstract class Person {
    private String name; // Имя персоны
    private int age; // Возраст персоны

    /**
     * Конструктор для инициализации персоны с именем и возрастом.
     * @param name Имя персоны.
     * @param age Возраст персоны.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Получить имя персоны.
     * @return Имя персоны.
     */
    public String getName() {
        return name;
    }

    /**
     * Установить имя персоны.
     * @param name Имя персоны.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получить возраст персоны.
     * @return Возраст персоны.
     */
    public int getAge() {
        return age;
    }

    /**
     * Установить возраст персоны.
     * @param age Возраст персоны.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Переопределение метода toString для вывода информации о персоне.
     * @return Строковое представление объекта Person.
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}