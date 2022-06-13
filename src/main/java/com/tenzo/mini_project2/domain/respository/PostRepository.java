package com.tenzo.mini_project2.domain.respository;

import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByUser(User user);

    Optional<Post> findByIdAndUser(Long userId, User user);
}
