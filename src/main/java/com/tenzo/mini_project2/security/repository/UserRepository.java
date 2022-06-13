package com.tenzo.mini_project2.security.repository;


import com.tenzo.mini_project2.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);
}