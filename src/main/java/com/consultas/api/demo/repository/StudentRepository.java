package com.consultas.api.demo.repository;

import com.consultas.api.demo.dto.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Optional<Student>> findStudentsByLastName(String lastName);
    Optional<Student> findStudentByEmail(String email);

}
