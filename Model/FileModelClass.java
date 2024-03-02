package Model;
import Controller.Interface.iGetModel;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import Model.Domain.*;
import java.util.List;
import java.util.ArrayList;

public class FileModelClass implements iGetModel {
    private String fileName;

    // Конструктор, но для файла
    public FileModelClass(String fileName) {
        this.fileName = fileName;

        try(FileWriter fw = new FileWriter(fileName, true))
        {
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Получение всего списка студентов через файл
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<Student>();
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null)
            {
                String[] param = line.split(" ");
                Student pers = new Student(param[0], Integer.parseInt(param[1]));
                students.add(pers);
                line = reader.readLine();
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return students;
    }

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


    // Сохранение списка в файл
    public void saveAllStudentToFile(List<Student> students)
    {
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            for(Student pers : students)
            {
                fw.write(pers.getName()+" "+pers.getAge()+" "+pers.getId());
                fw.append('\n');
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}