package com.FacultyManagement.FacultyMgmtAPI.controller;

import com.FacultyManagement.FacultyMgmtAPI.model.Faculty;
import com.FacultyManagement.FacultyMgmtAPI.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyRepository facultyRepository;

    @GetMapping
    public List<Faculty> getAllFaculty()
    {
        return facultyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty>getFacultyById(@PathVariable int id)
    {
        Optional<Faculty> faculty=facultyRepository.findById(id);
                return faculty.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Faculty>createFaculty(@RequestBody Faculty faculty)
    {
        Faculty savedFaculty=facultyRepository.save(faculty);
        return ResponseEntity.ok(savedFaculty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty>updateFaculty(@PathVariable int id, @RequestBody Faculty faculty)
    {
        Optional<Faculty>existingFaculty=facultyRepository.findById(id);
        if(existingFaculty.isPresent())
        {
           Faculty updatedFaculty= existingFaculty.get();
           updatedFaculty.setName(faculty.getName());
           updatedFaculty.setEmail(faculty.getEmail());
           updatedFaculty.setDepartment(faculty.getDepartment());
           updatedFaculty.setGender(faculty.getGender());
           updatedFaculty.setExperience(faculty.getExperience());
           facultyRepository.save(updatedFaculty);

           return ResponseEntity.ok(updatedFaculty);
        }
        else {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Faculty>deleteFaculty(@PathVariable int id)
    {
        if(facultyRepository.existsById(id))
        {
            facultyRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
