package com.integrationabdi.springintegrationtesting.service;

import com.integrationabdi.springintegrationtesting.dto.StudentRequest;
import com.integrationabdi.springintegrationtesting.dto.StudentResponse;
import com.integrationabdi.springintegrationtesting.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    ResponseEntity<Student> createStudent(StudentRequest studentResponse);

    List<StudentResponse>getAllStudent();

    Optional<Student> findStudentById(Long id);
}
