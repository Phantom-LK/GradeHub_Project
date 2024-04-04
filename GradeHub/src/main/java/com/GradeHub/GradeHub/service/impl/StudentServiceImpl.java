package com.GradeHub.GradeHub.service.impl;

import com.GradeHub.GradeHub.entity.Student;
import com.GradeHub.GradeHub.repository.StudentRepository;
import com.GradeHub.GradeHub.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl  implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

}
