package com.tenzo.mini_project2.domain.respository;

import com.tenzo.mini_project2.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByNickName(String nickName);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByNickNameAndPassword(String nickName, String password);

}