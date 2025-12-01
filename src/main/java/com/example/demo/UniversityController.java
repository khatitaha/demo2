package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityRepository universityRepository;

    @PostMapping("/add")
    public Map<String, String> add(@RequestBody University university) {
        universityRepository.save(university);
        return Map.of("message", "new university is added");
    }

    @GetMapping("/getAll")
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Map<String, Object> getUniversityById(@PathVariable int id) {
        Optional<University> univ = universityRepository.findById(id);

        if (univ.isEmpty()) {
            return Map.of("error", "University not found");
        }

        return Map.of("university", univ.get());
    }
}
