package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityRepository universityRepository;

    @PostMapping("/add")
    public String add(@RequestBody University university) {
        universityRepository.save(university);
        return "New university added";
    }

    @GetMapping("/getAll")
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }
}
