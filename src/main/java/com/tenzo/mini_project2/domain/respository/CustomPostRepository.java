package com.tenzo.mini_project2.domain.respository;

import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.web.dto.commentDto.CommentsResponseDto;


import java.util.List;

public interface CustomPostRepository {
    List<Post>getPosts();

    List<CommentsResponseDto> getComments(Long postId);
}
