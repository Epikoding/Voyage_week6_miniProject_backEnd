package com.tenzo.mini_project2.domain.respository;

import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>, CustomPostRepository {
    List<Post> findAllByUser(User user);
    Optional<Post> findByIdAndUser(Long postId, User user);
}
