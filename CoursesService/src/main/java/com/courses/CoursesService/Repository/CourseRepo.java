package com.courses.CoursesService.Repository;

import com.courses.CoursesService.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course,Integer> {
    List<Course> findAllByStudentId(int studetnId);
}
