package com.courses.CoursesService.Service;

import com.courses.CoursesService.Repository.CourseRepo;
import com.courses.CoursesService.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    Course createCourse(Course course);
    Course getCourseById(int courseId);
    List<Course> getAllCourses();

}
