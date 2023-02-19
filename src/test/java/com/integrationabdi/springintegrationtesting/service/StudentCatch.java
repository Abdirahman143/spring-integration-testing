package com.integrationabdi.springintegrationtesting.service;

import com.integrationabdi.springintegrationtesting.model.Student;
import com.integrationabdi.springintegrationtesting.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)

public class StudentCatch {

    @MockBean
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;


    @Test
    public void getMultipleId(){
        long id =12l;
        //give
        given(studentRepository.findById(id)).willReturn(Optional.of(new Student(
                "Mohamed",
                "Abdi",
                "mohamed.abdi@cbc.edu.com",
                "sw25-2022",
                new Date(2021,02,13,8,34),
                new Date("02/13/2025")
        )));

        studentService.findStudentById(id);
        studentService.findStudentById(id);
        studentService.findStudentById(id);
        studentService.findStudentById(id);

     then(studentRepository.findById(id)).should(times(1)).get().getId();

    }
}
