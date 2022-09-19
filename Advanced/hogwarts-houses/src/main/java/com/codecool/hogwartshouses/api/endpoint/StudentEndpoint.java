package com.codecool.hogwartshouses.api.endpoint;

import com.codecool.hogwartshouses.logic.StudentService;
import com.codecool.hogwartshouses.persistence.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentEndpoint {
    private final StudentService studentService;

    @GetMapping
    List<Student> getAll() {
        return studentService.findAll();
    }
    @PutMapping
    Student put(@RequestBody Student student){
        return studentService.save(student);
    }
}
