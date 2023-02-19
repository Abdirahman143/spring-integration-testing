package com.integrationabdi.springintegrationtesting.service;


import com.integrationabdi.springintegrationtesting.dto.StudentRequest;
import com.integrationabdi.springintegrationtesting.dto.StudentResponse;
import com.integrationabdi.springintegrationtesting.exception.StudentNotFoundException;
import com.integrationabdi.springintegrationtesting.mapper.StudentResponseMapper;
import com.integrationabdi.springintegrationtesting.model.Student;
import com.integrationabdi.springintegrationtesting.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository ;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<Student> createStudent(StudentRequest studentResponse){
        Student student = new Student(
                studentResponse.getFirstName(),
                studentResponse.getLastName(),
                studentResponse.getEmail(),
                studentResponse.getRegNo(),
                studentResponse.getStartDate(),
                studentResponse.getEndDate()
        );
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
    }

    @Override
    public List<StudentResponse> getAllStudent(){
        List<Student>students = studentRepository.findAll();
       return students.stream().map(student ->
               StudentResponseMapper.
                       MapToStudent(student)).toList();
    }



    @Override
    @Cacheable
    public Optional<Student> findStudentById(Long id) {
      return Optional.ofNullable(studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException()));
    }
}
