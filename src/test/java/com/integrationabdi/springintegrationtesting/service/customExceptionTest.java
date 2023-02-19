package com.integrationabdi.springintegrationtesting.service;


import com.integrationabdi.springintegrationtesting.exception.StudentNotFoundException;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class customExceptionTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void getId(){

        //given
           long id =24;
        //when
        Throwable throwable = catchThrowable(()->studentService.findStudentById(id));

        //then
        BDDAssertions.then(throwable).isInstanceOf(StudentNotFoundException.class);
    }
}
