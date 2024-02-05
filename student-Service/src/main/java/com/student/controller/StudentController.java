package com.student.controller;

import com.student.Service.StudentServiceImpl;
import com.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;
    @PostMapping("")
    public ResponseEntity<String> cretateStudent(@RequestBody Student student){
        this.studentService.createStudent(student);
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList=this.studentService.getAllStudent();

        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable int studentId){
        Student student=this.studentService.getStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
