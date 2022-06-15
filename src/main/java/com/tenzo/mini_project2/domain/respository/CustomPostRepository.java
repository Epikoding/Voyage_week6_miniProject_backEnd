package com.tenzo.mini_project2.domain.respository;

import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.web.dto.postDto.PostResponseDto;

import java.util.List;

public interface CustomPostRepository {
    List<Post>getPosts();
}
