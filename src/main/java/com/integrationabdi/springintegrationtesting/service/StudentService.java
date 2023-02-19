package com.integrationabdi.springintegrationtesting.service;

import com.integrationabdi.springintegrationtesting.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    ResponseEntity<Student> createStudent(Student student);

    ResponseEntity<List<Student>>getAllStudent();

    Optional<Student> findStudentById(Long id);
}
