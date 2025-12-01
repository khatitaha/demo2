package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Studentservice {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UniversityRepository universityRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Object> getAllStudentsUniversity() {
        return studentRepository.getAllStudentsUniversity();
    }

    public List<Object> findStudentsByUniversity(String univName) {
        return studentRepository.findStudentsByUniversity(univName);
    }

    // 🔥 UPDATE student
    public void updateStudent(int id, Student newData) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setName(newData.getName());
        existing.setAddress(newData.getAddress());

        // handle university update too
        if (newData.getUniversity() != null) {
            University univ = universityRepository.findById(newData.getUniversity().getId())
                    .orElseThrow(() -> new RuntimeException("University not found"));
            existing.setUniversity(univ);
        }

        studentRepository.save(existing);
    }

    // ❌ DELETE student
    public void deleteStudent(int id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.deleteById(id);
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

}