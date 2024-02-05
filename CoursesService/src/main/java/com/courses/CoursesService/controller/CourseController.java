package com.courses.CoursesService.controller;

import com.courses.CoursesService.Service.CourseServiceImpl;
import com.courses.CoursesService.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    @PostMapping("")
    public ResponseEntity<String> createCourse(@RequestBody Course course){
        Course course1=this.courseService.createCourse(course);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable int courseId){
        Course course=this.courseService.getCourseById(courseId);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Course>> getCourseByStudentId(@PathVariable int studentId){
        List<Course> courses= this.courseService.getAllCoursesByStudentId(studentId);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<Course>> getCourses(){
        List<Course> courses=this.courseService.getAllCourses();
        return new ResponseEntity<>(courses,HttpStatus.OK);
    }

}
