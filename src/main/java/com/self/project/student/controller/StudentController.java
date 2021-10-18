package com.self.project.student.controller;

import com.self.project.student.model.Student;
import com.self.project.student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

//    static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students")
    public ResponseEntity<Object> getStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        return studentService.updateStudent(student,id);
    }

    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteStudent(@PathVariable("id") Integer id) {
        return studentService.deleteStudent(id);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getStudent(@PathVariable("id") Integer id) {
        return studentService.getStudentById(id);
    }
}
