package com.self.project.student.service;

import com.self.project.student.model.Student;
import org.springframework.http.ResponseEntity;


public interface StudentService {
    ResponseEntity<Object> getAllStudents();

    ResponseEntity<Object> updateStudent(Student student, Integer id);

    ResponseEntity<Object> createStudent(Student student);

    ResponseEntity<Object> deleteStudent(Integer id);

    ResponseEntity<Object> getStudentById(Integer id);
}
