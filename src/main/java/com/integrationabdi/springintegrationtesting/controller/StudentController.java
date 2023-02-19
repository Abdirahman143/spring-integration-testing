package com.integrationabdi.springintegrationtesting.controller;

import com.integrationabdi.springintegrationtesting.model.Student;
import com.integrationabdi.springintegrationtesting.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student>Create(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping()
    public ResponseEntity<List<Student>>findAll(){
        return  studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Optional<Student> getById(
            @PathVariable Long id){
        return studentService.findStudentById(id);
    }
}
