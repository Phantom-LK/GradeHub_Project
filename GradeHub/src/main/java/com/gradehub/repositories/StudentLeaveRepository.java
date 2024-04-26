package com.gradehub.repositories;

import com.gradehub.entities.StudentLeave;
import com.gradehub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentLeaveRepository extends JpaRepository<StudentLeave, Long> {
    List<StudentLeave> findAllByUser_id(Long userId);

    default List<StudentLeave> findAllByUser(User user) {
        return findAllByUser_id(user.getId());
    }
}
