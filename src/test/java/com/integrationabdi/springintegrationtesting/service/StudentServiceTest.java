package com.integrationabdi.springintegrationtesting.service;

import com.integrationabdi.springintegrationtesting.model.Student;
import com.integrationabdi.springintegrationtesting.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class StudentServiceTest {


   private StudentService studentService;
   private StudentRepository studentRepository;
    @Autowired
    public StudentServiceTest(StudentService studentService,StudentRepository studentRepository){
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }


    @Test
    void createStudent() {
        //given
     Student savedStudent=  studentRepository.save(new Student(
                "Mohamed",
                "Abdi",
                "mohamed.abdi@cbc.edu.com",
                "sw25-2022",
                new Date(2021,02,13,8,34),
                new Date("02/13/2025")
        ));

        //when
         Optional<Student> student = studentService.findStudentById(savedStudent.getId());

        //then
        then(student.stream().filter(s->s.getFirstName().isBlank()));
        assertEquals(student.get().getEmail(),"mohamed.abdi@cbc.edu.com");
        assertNotNull(student.get().getId());

    }

    @Test
    void getAllStudent() {
      long id =12l;
      studentService.findStudentById(id);
      studentService.findStudentById(id);
      studentService.findStudentById(id);





    }
}