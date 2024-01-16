package com.courses.CoursesService.Repository;

import com.courses.CoursesService.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}
