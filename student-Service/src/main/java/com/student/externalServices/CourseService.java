package com.student.externalServices;

import com.student.model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "COURSES-SERVICE")
public interface CourseService {
    @GetMapping("/course/student/{studentId}")
    List<Course> getCourses(@PathVariable int studentId);
}
