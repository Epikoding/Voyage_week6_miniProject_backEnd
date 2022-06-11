package com.tenzo.mini_project2.domain.respository;

import com.tenzo.mini_project2.domain.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
