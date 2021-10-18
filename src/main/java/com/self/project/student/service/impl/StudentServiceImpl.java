package com.self.project.student.service.impl;

import com.self.project.student.exception.StudentNotFoundException;
import com.self.project.student.model.Student;
import com.self.project.student.repository.StudentRepository;
import com.self.project.student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<Object> getAllStudents() {
        logger.debug("Get All Students");
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> updateStudent(Student newStudent, Integer id) {
        Optional<Student> oldStudent = studentRepository.findById(id);
        oldStudent.get().setId(newStudent.getId());
        oldStudent.get().setEmail(newStudent.getEmail());
        oldStudent.get().setAddress(newStudent.getAddress());
        oldStudent.get().setName(newStudent.getName());
        oldStudent.get().setPhone_number(newStudent.getPhone_number());
        studentRepository.save(oldStudent.get());
        return new ResponseEntity<>("Student is update successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> createStudent(Student student) {
        studentRepository.save(student);
        return new ResponseEntity<>("Student is create successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteStudent(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        studentRepository.delete(student.get());
        return new ResponseEntity<>("Student is delete successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getStudentById(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if(!student.isPresent()) throw new StudentNotFoundException();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
