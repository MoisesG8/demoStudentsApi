package com.consultas.api.demo.controllers;

import com.consultas.api.demo.dto.Student;
import com.consultas.api.demo.services.StudentService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        System.out.println(student);
        Student createdStudent = studentService.addStudent(student);
        return new ResponseEntity<>("Creado con exito", HttpStatus.CREATED);
    }


    @GetMapping("/getStudentsByLastName/{lastname}")
    public ResponseEntity<List<Optional>> getStudentByLastName(@PathVariable String lastname) {
        System.out.println("datos "+ lastname);
        return new ResponseEntity(studentService.findByLastName(lastname), HttpStatus.OK);
    }

    @GetMapping("/getStudentByID/{id}")
    public ResponseEntity<Optional<Student>> getStudentByID(@PathVariable String id){
        return new ResponseEntity<Optional<Student>>(studentService.getStudentByID(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


}
