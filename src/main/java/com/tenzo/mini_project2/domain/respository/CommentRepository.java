package com.tenzo.mini_project2.domain.respository;

import com.tenzo.mini_project2.domain.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
