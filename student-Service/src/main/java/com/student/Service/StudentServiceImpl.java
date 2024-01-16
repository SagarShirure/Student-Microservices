package com.student.Service;

import com.student.Repository.StudentRepo;
import com.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;


    @Override
    public Student createStudent(Student student) {
        return this.studentRepo.save(student);
    }

    @Override
    public Student getStudentById(int studentId) {
        Student student = this.studentRepo.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found with id" + studentId));
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        return this.studentRepo.findAll();
    }
}
