package com.student.Service;

import com.student.Repository.StudentRepo;
import com.student.externalServices.CourseService;
import com.student.model.Course;
import com.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CourseService courseService;


    @Override
    public Student createStudent(Student student) {
        return this.studentRepo.save(student);
    }

    @Override
    public Student getStudentById(int studentId) {
        Student student = this.studentRepo.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found with id" + studentId));

        Course[] forObject = this.restTemplate.getForObject("http://COURSES-SERVICE/course/student/"+student.getStudentId(), Course[].class);
        List<Course> courses= Arrays.asList(forObject);
        student.setCourses(courses);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students=this.studentRepo.findAll();

        List<Student> studentList = students.stream().map(
                student -> {
                    List<Course> courses = this.courseService.getCourses(student.getStudentId());
                    student.setCourses(courses);
                    return student;
                }
        ).collect(Collectors.toList());
        return studentList;
    }
}
