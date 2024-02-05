package com.courses.CoursesService.Service;

import com.courses.CoursesService.Repository.CourseRepo;
import com.courses.CoursesService.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;
    @Override
    public Course createCourse(Course course) {
        Course course1=this.courseRepo.save(course);
        return course1;
    }

    @Override
    public Course getCourseById(int courseId) {
        Course course = this.courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not fount with id : " + courseId));
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses=this.courseRepo.findAll();
        return courses;
    }

    public List<Course> getAllCoursesByStudentId(int studentId) {
        List<Course> courses=this.courseRepo.findAllByStudentId(studentId);
        return courses;
    }
}
