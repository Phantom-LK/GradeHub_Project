package com.gradehub.repositories;

import com.gradehub.entities.User;
import com.gradehub.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    User findByRole(UserRole userRole);
}
