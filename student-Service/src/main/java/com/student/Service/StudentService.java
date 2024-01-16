package com.student.Service;

import com.student.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(int studentId);
    List<Student> getAllStudent();
}
