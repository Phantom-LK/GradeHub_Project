package com.gradehub.repositories;

import com.gradehub.entities.StudentLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLeaveRepository extends JpaRepository<StudentLeave, Long> {
}
