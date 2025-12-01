package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private Studentservice studentService;

    @PostMapping("/add")
    public Map<String, String> add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return Map.of("message", "new student is added");
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

    @PutMapping("/update/{id}")
    public Map<String, String> updateStudent(@PathVariable int id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        // return "student updated successfully";
        return Map.of("message", "student updated successfully");
    }

    // ❌ DELETE student
    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        // return "student deleted successfully";
        return Map.of("message", "student deleted successfully");
    }

}