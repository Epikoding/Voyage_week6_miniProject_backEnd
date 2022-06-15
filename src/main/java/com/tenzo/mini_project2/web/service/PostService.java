package com.tenzo.mini_project2.web.service;

import com.tenzo.mini_project2.domain.models.Comment;
import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.domain.models.Tags;
import com.tenzo.mini_project2.domain.respository.CommentRepository;
import com.tenzo.mini_project2.domain.respository.PostRepository;
import com.tenzo.mini_project2.domain.respository.TagRepository;
import com.tenzo.mini_project2.security.UserDetailsImpl;
import com.tenzo.mini_project2.security.repository.UserRepository;
import com.tenzo.mini_project2.web.dto.commentDto.CommentDto;
import com.tenzo.mini_project2.web.dto.myPageDto.MyPageRequestDto;
import com.tenzo.mini_project2.web.dto.postDto.PostRequestDto;
import com.tenzo.mini_project2.web.dto.postDto.PostResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public List<Tags> getAllTags() {
        return tagRepository.getTags();
    }

    public List<PostResponseDto> getPostAll() {
        List<Post> posts = postRepository.getPosts();
        List<PostResponseDto> results = new LinkedList<>();
        for (Post post : posts) {
            results.add(new PostResponseDto(post));
        }
        return results;

    }

    @Transactional
    // TODO: 2022/06/13 아래 방식이 맞는지 확인 받아야함.
    public ResponseEntity<?> enrollMeme(@AuthenticationPrincipal UserDetailsImpl userDetails, PostRequestDto postRequestDto) {

        Post post = Post.builder()
                .user(userDetails.getUser())
                .title(postRequestDto.getTitle())
                .imgUrl(postRequestDto.getImgUrl())
                .down_layer_value(postRequestDto.getDown_layer_value())
                .up_layer_value(postRequestDto.getUp_layer_value())
                .up_txt(postRequestDto.getUp_txt())
                .down_txt(postRequestDto.getDown_txt())
                .tagList(new HashSet<>(tagRepository.saveAll(resolveTags(postRequestDto))))
                .commentList(new LinkedList<>())
                .build();
        postRepository.save(post);
        return new ResponseEntity<>("등록 완료", HttpStatus.OK);
        // RestControllerAdvice 이런게 있다....
    }

    public ResponseEntity<?> getCommentsById(Long postId) {
        return new ResponseEntity<>(postRepository.getComments(postId), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> postComment(@AuthenticationPrincipal UserDetailsImpl userDetails, CommentDto commentDto) {
        Post postFound = postRepository.findById(commentDto.getPostId()).orElseThrow(
                () -> new IllegalArgumentException("코멘트를 작성할 수 없는 게시글입니다.")
        );
        List<Comment> commentList = postFound.getCommentList();

        Comment comment = Comment.builder()
                .userId(userDetails.getUser())
                .content(commentDto.getComment())
                .postId(commentDto.getPostId())
                .build();

        commentList.add(commentRepository.save(comment));
        postFound.setCommentList(commentList);

        postRepository.save(postFound);
        return new ResponseEntity<>("등록 완료", HttpStatus.OK);
    }


    public List<Tags> resolveTags(PostRequestDto postRequestDto) {
        List<Tags> list = new LinkedList<>();
        for (String tag : postRequestDto.getTagList()) {
            list.add(new Tags(tag));
        }
        return list;
    }
}
