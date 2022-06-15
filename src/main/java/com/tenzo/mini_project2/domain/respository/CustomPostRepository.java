package com.tenzo.mini_project2.domain.respository;

import com.tenzo.mini_project2.domain.models.Comment;
import com.tenzo.mini_project2.domain.models.Post;


import java.util.List;

public interface CustomPostRepository {
    List<Post>getPosts();

    List<Comment> getComments(Long postId);
}
