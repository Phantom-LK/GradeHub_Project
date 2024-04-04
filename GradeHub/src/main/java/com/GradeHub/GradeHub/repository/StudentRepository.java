package com.GradeHub.GradeHub.repository;

import com.GradeHub.GradeHub.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Long> {

}
