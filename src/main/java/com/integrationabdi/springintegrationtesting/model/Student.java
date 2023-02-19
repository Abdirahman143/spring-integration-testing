package com.integrationabdi.springintegrationtesting.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name ="students_test_table",
        uniqueConstraints = {
         @UniqueConstraint(
                 name = "student_email_unique",
                 columnNames = "email"
         ),
                @UniqueConstraint(
                        name = "student_regNo_unique",
                        columnNames = "regNo"
                )
        }
)

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @NotNull
     @Size(min = 2, max = 20)
    private String firstName;
     @Size(min = 2, max = 20)
    private String lastName;
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;
    private String regNo;
    @JsonFormat(pattern = "dd/mm/yyy hh:mm")
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date startDate;
    @Future(message = "please ending date should be future ")
    @JsonFormat(pattern = "dd/mm/yyy")
    @Temporal(TemporalType.DATE)
     private Date endDate;

    public Student(String firstName,
                   String lastName,
                   String email,
                   String regNo,
                   Date startDate,
                   Date endDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.regNo = regNo;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
