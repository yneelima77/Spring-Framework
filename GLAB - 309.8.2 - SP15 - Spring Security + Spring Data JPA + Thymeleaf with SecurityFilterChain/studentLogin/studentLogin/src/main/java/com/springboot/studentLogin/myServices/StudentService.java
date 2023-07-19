package com.springboot.studentLogin.myServices;

import com.springboot.studentLogin.dto.StudentDto;
import com.springboot.studentLogin.model.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(StudentDto studentDto);
    Student findStudentByEmail(String email);
    List<StudentDto> findAllStudents();
}
