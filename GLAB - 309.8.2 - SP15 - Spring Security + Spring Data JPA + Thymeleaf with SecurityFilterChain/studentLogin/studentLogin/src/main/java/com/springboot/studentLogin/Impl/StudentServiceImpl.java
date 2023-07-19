package com.springboot.studentLogin.Impl;

import com.springboot.studentLogin.dto.StudentDto;
import com.springboot.studentLogin.model.Role;
import com.springboot.studentLogin.model.Student;
import com.springboot.studentLogin.myServices.StudentService;
import com.springboot.studentLogin.repository.RoleRepository;
import com.springboot.studentLogin.repository.StudentRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public StudentServiceImpl(StudentRepository studentRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        super();
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getFirstName() + " " + studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        // Encrypt the password using Spring Security
        student.setPassword(passwordEncoder.encode(studentDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null) {
            role = checkRoleExist();
        }
        //check if role exists before setting it to student
        student.setRoles(Arrays.asList(role));
        studentRepository.save(student);
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    @Override
    public Student findStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public List<StudentDto> findAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList.stream().map(this::mapToStudentDto).collect(Collectors.toList());
    }

    // method maps the Student object to the StudentDto object
    // StudentDto checks and validates empty fields.
    //Student object name returned from the database is parsed out as separate strings for firstName and lastName and set to a StudentDto object.

    private StudentDto mapToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();

        String[] str = student.getName().split(" ");
        studentDto.setFirstName(str[0]);
        studentDto.setLastName(str[1]);
        studentDto.setEmail(student.getEmail());
        return studentDto;
    }
}
