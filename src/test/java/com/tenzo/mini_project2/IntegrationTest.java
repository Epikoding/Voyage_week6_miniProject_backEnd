package com.tenzo.mini_project2;


import com.tenzo.mini_project2.domain.models.Comment;
import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.domain.models.Tags;
import com.tenzo.mini_project2.domain.respository.CommentRepository;
import com.tenzo.mini_project2.domain.respository.PostRepository;
import com.tenzo.mini_project2.domain.respository.TagRepository;
import com.tenzo.mini_project2.security.UserDetailsImpl;
import com.tenzo.mini_project2.security.dto.SignupRequestDto;
import com.tenzo.mini_project2.security.model.User;
import com.tenzo.mini_project2.security.repository.UserRepository;
import com.tenzo.mini_project2.security.service.UserService;
import com.tenzo.mini_project2.web.dto.commentDto.CommentDto;
import com.tenzo.mini_project2.web.dto.commentDto.CommentsResponseDto;
import com.tenzo.mini_project2.web.dto.postDto.PostRequestDto;
import com.tenzo.mini_project2.web.dto.postDto.PostResponseDto;
import com.tenzo.mini_project2.web.service.PostService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class IntegrationTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("댓글 등록 및 조회 테스트")
    @Transactional
    void test() {
        SignupRequestDto user1 = SignupRequestDto.builder()
                .email("test1@naver,com")
                .nickname("test1")
                .password("123123")
                .build();
        ResponseEntity<?> signup = userService.signup(user1);
        User user = (User) signup.getBody();

        UserDetailsImpl userDetails = new UserDetailsImpl(user);
        List<String> tags = Arrays.asList("별로", "밎냐?");
        PostRequestDto postRequestDto = new PostRequestDto();
        postRequestDto.setTitle("test");
        postRequestDto.setDown_txt("test");
        postRequestDto.setTagList(tags);
        postRequestDto.setImgUrl("test");
        postRequestDto.setUp_layer_value("test");
        postRequestDto.setUp_txt("test");
        postRequestDto.setDown_layer_value("test");

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

        Post post1 = postRepository.save(post);
        List<Comment> commentList = post1.getCommentList();
        CommentDto commentDto = CommentDto.builder()
                .postId(post1.getId())
                .comment("test입니다.")
                .userId(user.getId())
                .build();

        Comment comment = Comment.builder()
                .userId(userDetails.getUser())
                .content(commentDto.getComment())
                .build();

        commentList.add(commentRepository.save(comment));

        post1.setCommentList(commentList);
        Post save = postRepository.save(post1);


        List<Comment> commentss = postRepository.getComments(save.getId());
        List<PostResponseDto> postAll = postService.getPostAll();
    }

    public List<com.tenzo.mini_project2.domain.models.Tags> resolveTags(PostRequestDto postRequestDto) {
        List<com.tenzo.mini_project2.domain.models.Tags> list = new LinkedList<>();
        for (String tag : postRequestDto.getTagList()) {
            list.add(new Tags(tag));
        }
        return list;
    }
//    private SignupRequestDto user1 = SignupRequestDto.builder()
//            .email("test1@naver,com")
//            .nickname("test1")
//            .password("123123")
//            .build();
//
//    private SignupRequestDto user2 = SignupRequestDto.builder()
//            .email("test2@naver,com")
//            .nickname("test2")
//            .password("123123")
//            .build();
//
//    private SignupRequestDto user3 = SignupRequestDto.builder()
//            .email("test3@naver,com")
//            .nickname("test3")
//            .password("123123")
//            .build();


}






