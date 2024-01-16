package com.student.model;

import lombok.Data;

@Data
public class Course {
    private int courseId;
    private int studentId;
    private String courseName;
    private long courseFees;

}
