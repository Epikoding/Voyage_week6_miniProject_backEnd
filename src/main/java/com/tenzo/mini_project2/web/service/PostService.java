package com.tenzo.mini_project2.web.service;

import com.tenzo.mini_project2.domain.models.Comment;
import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.domain.models.User;
import com.tenzo.mini_project2.domain.respository.CommentRepository;
import com.tenzo.mini_project2.domain.respository.PostRepository;
import com.tenzo.mini_project2.domain.respository.UserRepository;
import com.tenzo.mini_project2.security.jwt.UserDetailsImpl;
import com.tenzo.mini_project2.web.dto.commentDto.CommentDto;
import com.tenzo.mini_project2.web.dto.postDto.PostRequestDto;
import com.tenzo.mini_project2.web.dto.postDto.postResponseDto;
import com.tenzo.mini_project2.web.validator.UserValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    private final UserValidator userValidator;
    @Transactional
    // TODO: 2022/06/13 아래 방식이 맞는지 확인 받아야함.
    public postResponseDto enrollMeme(@AuthenticationPrincipal UserDetailsImpl userDetails, PostRequestDto postRequestDto) {
        Post post = Post.builder()
                .user(userDetails.getUser()) // TODO: 2022/06/11    "유저 정보를 가져와야함" authentification, principal 필요. -> 수정해봄 일단.
                .title(postRequestDto.getTitle())
                .imgUrl(postRequestDto.getImgUrl())
                .tags(postRequestDto.getTags())
                .position(postRequestDto.getPosition()) // FIXME: 2022/06/11 태그 위치값 값 가져와야 함.
                .build();

        postRepository.save(post);
        return null;
    }
    @Transactional
    public Comment postComment(CommentDto commentDto) {
        Post postFound = postRepository.findById(commentDto.getPostId()).get();
        User userFound = userRepository.findUserById(commentDto.getUserId()).get();

        Comment comment = Comment.builder()
                .userId(userFound)
                .postId(postFound)
                .content(commentDto.getComment())
                .build();

        commentRepository.save(comment);
        return comment;
    }
}
