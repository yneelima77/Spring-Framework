package com.springboot.dataJPA.controller;

import com.springboot.dataJPA.model.Student;
import com.springboot.dataJPA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    //Read all student data
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    //Read or creating Student by Account number
    @GetMapping("/students/{accountNo}")
    public Student findstudentbyaccount(@PathVariable Long accountNo) {
        return studentRepository.findByAccountNo(accountNo);
    }

    //add student detail in the database
    @PostMapping("/Addstudent")
    public long saveStudent(@RequestBody Student st) {
        studentRepository.save(st);
        return st.getId();
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteStudentbyId(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllStudent() {
        studentRepository.deleteAll();
    }

    @PutMapping("/updateStudentById/{id}")
    private void updateStudent(@PathVariable("id") long stuid, @RequestBody Student stuObj) {
        Optional<Student> stuData = studentRepository.findById(stuid);
        if (stuData.isPresent()) {
            Student s = stuData.get();
            s.setName(stuObj.getName());
            s.setAccountNo(stuObj.getAccountNo());
            s.setId(stuObj.getId());
            s.setMarks(stuObj.getMarks());
            studentRepository.save(s);

        }
    }

}
