package Model;
import Controller.Interface.iGetModel;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import Model.Domain.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Класс FileModelClass реализует интерфейс iGetModel для работы с данными студентов через файл.
 */
public class FileModelClass implements iGetModel {
    private String fileName; // Имя файла для хранения данных

    /**
     * Конструктор класса, инициализирующий объект для работы с файлом.
     * @param fileName Имя файла для работы.
     */
    public FileModelClass(String fileName) {
        this.fileName = fileName;

        try(FileWriter fw = new FileWriter(fileName, true))
        {
            fw.flush(); // Создание файла, если он не существует
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Получает всех студентов из файла.
     * @return Список студентов, считанный из файла.
     */
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line != null)
            {
                String[] param = line.split(" ");
                Student student = new Student(param[0], Integer.parseInt(param[1]));
                students.add(student);
                line = reader.readLine();
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return students;
    }

    /**
     * Удаляет студента из списка по его идентификатору и сохраняет изменения в файл.
     * @param num Идентификатор студента для удаления.
     */
    @Override
    public void removeFromList(int num) {
        List<Student> students = getAllStudent();
        boolean isExist = false;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == num) {
                isExist = true;
                students.remove(i);
                break;
            }
        }
        if (isExist) saveAllStudentToFile(students);

    }

    /**
     * Сохраняет список студентов в файл.
     * @param students Список студентов для сохранения.
     */
    public void saveAllStudentToFile(List<Student> students)
    {
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            for(Student student : students)
            {
                fw.write(student.getName() + " " + student.getAge() + " " + student.getId());
                fw.append('\n');
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}