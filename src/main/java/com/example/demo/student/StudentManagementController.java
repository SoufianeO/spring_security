package com.example.demo.student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> students = Arrays.asList(
            new Student(1,"Soufiane OUNIDA"),
            new Student(2,"Amine OUNIDA"),
            new Student(3,"Yahya OUNIDA")
    );

    @GetMapping
    public List<Student> getAllStudents(){
        System.out.println("getAllStudents");
        return students;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        System.out.println("registerNewStudent");
        System.out.println(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println("deleteStudent");
        System.out.println(studentId);
    }

    @PutMapping(path ="{studentId}")
    public void updateStudent(Integer studentId, Student student){
        System.out.println("updateStudent");
        System.out.println(String.format("%s %s", student, student));
    }

}
