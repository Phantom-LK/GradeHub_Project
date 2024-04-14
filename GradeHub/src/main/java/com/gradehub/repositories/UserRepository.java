package com.gradehub.repositories;

import com.gradehub.entities.User;
import com.gradehub.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    User findByRole(UserRole userRole);

    Optional<User> findFirstByEmail(String email);
}
