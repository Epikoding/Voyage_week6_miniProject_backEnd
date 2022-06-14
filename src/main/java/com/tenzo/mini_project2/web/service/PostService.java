package com.tenzo.mini_project2.web.service;

import com.tenzo.mini_project2.domain.models.Comment;
import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.domain.respository.CommentRepository;
import com.tenzo.mini_project2.domain.respository.PostRepository;
import com.tenzo.mini_project2.security.UserDetailsImpl;
import com.tenzo.mini_project2.security.repository.UserRepository;
import com.tenzo.mini_project2.web.dto.commentDto.CommentDto;
import com.tenzo.mini_project2.web.dto.postDto.PostRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;


    @Transactional
    // TODO: 2022/06/13 아래 방식이 맞는지 확인 받아야함.
    public ResponseEntity<?> enrollMeme(@AuthenticationPrincipal UserDetailsImpl userDetails, PostRequestDto postRequestDto) {
        Post post = Post.builder()
                .user(userDetails.getUser())
                .title(postRequestDto.getTitle())
                .imgUrl(postRequestDto.getImgUrl())
                .tags(postRequestDto.getTags())
                .position(postRequestDto.getPosition())
                .build();

        return new ResponseEntity<>(postRepository.save(post), HttpStatus.OK);
        // RestControllerAdvice 이런게 있다....
    }
    @Transactional
    public ResponseEntity<?> postComment(@AuthenticationPrincipal UserDetailsImpl userDetails, CommentDto commentDto) {
        Post postFound = postRepository.findById(commentDto.getPostId()).orElseThrow(
                () -> new IllegalArgumentException("코멘트를 작성할 수 없는 게시글입니다.")
        );

        Comment comment = Comment.builder()
                .userId(userDetails.getUser())
                .postId(postFound)    // Lombok 라이브러리
                .content(commentDto.getComment())
                .build();

        return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.OK);
    }
}
