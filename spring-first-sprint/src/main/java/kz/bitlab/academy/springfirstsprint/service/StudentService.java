package kz.bitlab.academy.springfirstsprint.service;

import kz.bitlab.academy.springfirstsprint.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private static List<StudentEntity> students = new ArrayList<>();
    private static Long id = 1L;

    static {
        students.add(new StudentEntity(id++, "Ilyas", "Zhuanyshev", 88, "B"));
        students.add(new StudentEntity(id++, "Serik", "Erikov", 91, "A"));
        students.add(new StudentEntity(id++, "Erik", "Serikov", 65, "C"));
        students.add(new StudentEntity(id++, "Nurzhan", "Bolatov", 48, "F"));
        students.add(new StudentEntity(id++, "Patrick", "Zuckerberg", 100, "A"));
    }

    public static List<StudentEntity> findAll() {
        return students;
    }

    public static String create(String name, String surname, int exam){
        if(name.isBlank())
            return "redirect:/addStudent?NameIsRequired";

        if(surname.isBlank())
            return "redirect:/addStudent?SurnameIsRequired";

        StudentEntity entity = generateStudent(name, surname, exam);
        students.add(entity);


        return "redirect:/";
    }

    private static StudentEntity generateStudent(String name, String surname, int exam){
        var student =  StudentEntity.builder()
                .id(id++)
                .name(name)
                .surname(surname)
                .exam(exam);

        if(exam >= 90){
            student.mark("A");
        } else if(exam >= 75 && exam <= 89){
            student.mark("B");
        } else if(exam >= 60 && exam <= 74){
            student.mark("C");
        }else if(exam >= 50 && exam <= 59){
            student.mark("D");
        }else{
            student.mark("F");
        }

        return student.build();
    }


}
