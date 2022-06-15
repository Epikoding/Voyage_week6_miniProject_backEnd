package com.tenzo.mini_project2.web.service;


import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.domain.models.Tags;
import com.tenzo.mini_project2.domain.respository.PostRepository;
import com.tenzo.mini_project2.domain.respository.TagRepository;
import com.tenzo.mini_project2.security.UserDetailsImpl;
import com.tenzo.mini_project2.web.dto.myPageDto.MyPageRequestDto;
import com.tenzo.mini_project2.web.dto.myPageDto.MyPageResponseDto;
import com.tenzo.mini_project2.web.dto.postDto.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MyPageService {
    private final PostRepository postRepository;
    private final TagRepository tagRepository;


    //    public List<MyPageResponseDto> showMyPage(Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        List<MyPageResponseDto> myPageResponseDtoArrayList = new ArrayList<>();
//
//        List<Post> postList = postRepository.findAllByUser(userDetails.getUser());
//        for (Post post : postList) {
//            MyPageResponseDto myPageResponseDto = MyPageResponseDto.builder()
//                    .postId(post.getId())
//                    .title(post.getTitle())
//                    .imgUrl(post.getImgUrl())
//                    .position(post.getPosition())
//                    .build();
//            myPageResponseDtoArrayList.add(myPageResponseDto);
//        }
//        return myPageResponseDtoArrayList;
//    }
// ↑ projection으로 다시 짜보기(시간되면)
    @Transactional
    public ResponseEntity<?> update(@AuthenticationPrincipal UserDetailsImpl userDetails, MyPageRequestDto myPageRequestDto) {


        Post postFoundInDb = postRepository.findByIdAndUser(myPageRequestDto.getId(), userDetails.getUser()).orElseThrow(
                () -> new IllegalArgumentException("수정권한이 없습니다.")
        );

        postFoundInDb.update(myPageRequestDto, resolveTags(myPageRequestDto));
        return new ResponseEntity<>(postRepository.save(postFoundInDb), HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Post postFoundInDb = postRepository.findByIdAndUser(postId, userDetails.getUser()).orElseThrow(
                () -> new IllegalArgumentException("삭제 권한이 없습니다."));

        postRepository.delete(postFoundInDb);

        return new ResponseEntity<>("삭제되었습니다.", HttpStatus.OK);
    }

    @Transactional
    public Set<Tags> resolveTags(MyPageRequestDto myPageRequestDto) {
        List<Tags> list = new LinkedList<>();

        for (String tag : myPageRequestDto.getTagList()) {
            list.add(new Tags(tag));
        }
        return new HashSet<>(tagRepository.saveAll(list));
    }
}
