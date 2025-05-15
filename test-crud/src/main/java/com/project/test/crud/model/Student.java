package com.project.test.crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="STUDENT_ID")
    private Long studentId;

    @Column(name="FIRST_NAME", length=20)
    private String firstName;

    @Column(name="LAST_NAME", length=20)
    private String lastName;

    @Column(name="GRADE")
    private Integer grade;

    @Column(name="ADDRESS")
    private String address  ;
}
