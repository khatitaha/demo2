package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private Studentservice studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getAllUniv")
    public List<Object> getAllStudentsUniversity() {
        return studentService.getAllStudentsUniversity();
    }

    @GetMapping("/findStudUniv")
    public List<Object> findStudentsByUniversity(@RequestParam String univName) {
        return studentService.findStudentsByUniversity(univName);
    }

}