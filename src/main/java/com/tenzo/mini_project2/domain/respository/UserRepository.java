package com.tenzo.mini_project2.domain.respository;

import com.tenzo.mini_project2.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(Long id);
    Optional<User> findById(Long id);

    boolean existsByEmail(String email);
}

// find 뒤에는 table이 들어온다.
// findUserById와 findById는 애초에 JpaRepository(User)라고 명시했기에 결국은 둘이 같은 것이다. 20220611 정찬