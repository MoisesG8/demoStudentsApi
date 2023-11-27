package com.consultas.api.demo.services;

import com.consultas.api.demo.dto.Student;
import com.consultas.api.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student s){

        return studentRepository.save(s);
    }

    public List<Optional<Student>> findByLastName(String lastName){
        List<Optional<Student>> estudiantes = studentRepository.findStudentsByLastName(lastName);

        return estudiantes;

    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentByID(String id){
        return studentRepository.findById(id);
    }

}
