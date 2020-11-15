package com.example.demo.student;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    //hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')
    public List<Student> getAllStudents(){
        System.out.println("getAllStudents");
        return students;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student){
        System.out.println("registerNewStudent");
        System.out.println(student);
    }

    @DeleteMapping(path="{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println("deleteStudent");
        System.out.println(studentId);
    }

    @PutMapping(path ="{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(Integer studentId, Student student){
        System.out.println("updateStudent");
        System.out.println(String.format("%s %s", student, student));
    }

}
