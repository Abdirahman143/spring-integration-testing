package com.integrationabdi.springintegrationtesting.mapper;

import com.integrationabdi.springintegrationtesting.dto.StudentResponse;
import com.integrationabdi.springintegrationtesting.model.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class StudentResponseMapper {

  public static StudentResponse MapToStudent(Student student) {
        return  StudentResponse
                .builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .regNo(student.getRegNo())
                .startDate(student.getStartDate())
                .endDate(student.getEndDate())
                .build();
    }

}
