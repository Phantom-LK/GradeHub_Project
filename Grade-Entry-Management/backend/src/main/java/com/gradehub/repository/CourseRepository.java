package com.gradehub.gradeentrymanagement.repository;

import com.gradehub.gradeentrymanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}