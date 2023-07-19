package com.springboot.dataJPA.repository;

import com.springboot.dataJPA.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    // following are custom methods
    Student findByAccountNo (Long accountNo);
    List<Student> findByNameContaining(String name);
}
