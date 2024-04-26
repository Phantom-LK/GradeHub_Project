package com.gradehub.gradeentrymanagement.repository;

import com.gradehub.gradeentrymanagement.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, GradeId> {
}
