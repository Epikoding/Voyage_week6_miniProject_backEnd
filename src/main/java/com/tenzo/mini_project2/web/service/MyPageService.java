package com.tenzo.mini_project2.web.service;


import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.domain.respository.PostRepository;
import com.tenzo.mini_project2.security.UserDetailsImpl;
import com.tenzo.mini_project2.web.dto.myPageDto.MyPageRequestDto;
import com.tenzo.mini_project2.web.dto.myPageDto.MyPageResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyPageService {
    private final PostRepository postRepository;

    @Autowired
    public MyPageService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<MyPageResponseDto> showMyPage(Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<MyPageResponseDto> myPageResponseDtoArrayList = new ArrayList<>();

        List<Post> postList = postRepository.findAllByUser(userDetails.getUser());
        for (Post post : postList) {
            MyPageResponseDto myPageResponseDto = MyPageResponseDto.builder()
                    .postId(post.getId())
                    .title(post.getTitle())
                    .imgUrl(post.getImgUrl())
                    .position(post.getPosition())
                    .build();
            myPageResponseDtoArrayList.add(myPageResponseDto);
        }
        return myPageResponseDtoArrayList;
    }
// ↑ projection으로 다시 짜보기(시간되면)
    @Transactional
    public ResponseEntity<?> update(@AuthenticationPrincipal UserDetailsImpl userDetails, MyPageRequestDto myPageRequestDto) {
        Post postFoundInDb = postRepository.findByIdAndUser(myPageRequestDto.getPostId(), userDetails.getUser()).orElseThrow(
                () -> new IllegalArgumentException("수정 권한이 없습니다."));

        postFoundInDb = Post.builder()
                .title(myPageRequestDto.getTitle())
                .tags(myPageRequestDto.getTag())
                .position(myPageRequestDto.getPosition())
                .build();

        return new ResponseEntity<>(postRepository.save(postFoundInDb), HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Post postFoundInDb = postRepository.findByIdAndUser(postId, userDetails.getUser()).orElseThrow(
                () -> new IllegalArgumentException("삭제 권한이 없습니다."));

        postRepository.delete(postFoundInDb);

        return new ResponseEntity<>("삭제되었습니다.", HttpStatus.OK);
    }
}
