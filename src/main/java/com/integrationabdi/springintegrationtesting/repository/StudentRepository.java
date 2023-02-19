package com.integrationabdi.springintegrationtesting.repository;

import com.integrationabdi.springintegrationtesting.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.rmi.StubNotFoundException;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByFirstName(String firstName);

    @Query(
            "select  s from Student  s where s.id=?1"
    )
    Student findStudentById(Integer id);
}
