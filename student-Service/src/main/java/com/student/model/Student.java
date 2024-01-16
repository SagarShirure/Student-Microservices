package com.student.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private long mobileNo;
    private String city;
    private String name;
    @Transient
    private List<Course> courses;

}
