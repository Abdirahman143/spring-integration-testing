package com.integrationabdi.springintegrationtesting.controller;

import com.integrationabdi.springintegrationtesting.exception.StudentNotFoundException;
import com.integrationabdi.springintegrationtesting.model.Student;
import com.integrationabdi.springintegrationtesting.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Date;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class StudentControllerTest {

    @Autowired
    private StudentService studentService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    MockMvc mockMvc;

    @Test
    public void getById_CreateStudent() throws Exception {

        //given
        given(studentService.findStudentById(anyLong())).willReturn(
                Optional.of(new Student(
                        1l,
                        "Mohamed",
                        "Abdi",
                        "mohamed.abdi@cbc.edu.com",
                        "sw25-2022",
                        new Date(2021,02,13,8,34),
                        new Date("02/13/2025")
                ))
        );
        //when //then
        mockMvc.perform(get("/api/v1/student/1"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("id").value(2l))
                .andExpect((ResultMatcher) jsonPath("firstName").value("Abdirahman"))
                .andExpect((ResultMatcher) jsonPath("lastName").value("Bashir"))
                .andExpect((ResultMatcher) jsonPath("email").value("bashir.abdi@gmail.com"))
                .andExpect((ResultMatcher) jsonPath("regNo").value("sw45-2022"))
                .andExpect((ResultMatcher) jsonPath("startDate").value(new Date("2022/02/02")))
                .andExpect((ResultMatcher) jsonPath("endDate").value(new Date("2023/02/04")));

    }

    @Test
    public void NotFoundWith404() throws Exception {

        //given
        given(studentService.findStudentById(anyLong())).willThrow(StudentNotFoundException.class);

        //when //then

        mockMvc.perform(get("/api/v1/student/2")).andExpect(status().isNotFound());

    }

}