package com.integrationabdi.springintegrationtesting.repository;

import com.integrationabdi.springintegrationtesting.model.Student;
import jakarta.persistence.Temporal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class studentRepositoryTest {
    @Autowired
 private StudentRepository studentRepository;

 //@Autowired//constructor autowiring -DI

//   public studentRepositoryTest (StudentRepository studentRepository){
//       this.studentRepository = studentRepository;
//   }


   @Test
   public void FindFirstName(){
      //create
       Student student = new Student(
               "Abdirahman",
               "Bashir",
               "abdirahman.bashir@cbc.edu",
               "sw23-2022",
               new Date(2022,02,13,8,34),
               new Date("02/13/2025")
       );

       studentRepository.save(student);
       //Given
       Student student1 = studentRepository.findByFirstName("Abdirahman");


       //When
       then(student1.getFirstName()).isEqualTo(student1.getFirstName());

       //then
      assertEquals(student1.getEmail(),"abdirahman.bashir@cbc.edu");
      assertNotNull(student1.getId());

   }



}