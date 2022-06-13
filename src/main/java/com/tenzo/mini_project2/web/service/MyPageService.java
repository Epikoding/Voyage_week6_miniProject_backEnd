package com.tenzo.mini_project2.web.service;


import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.domain.respository.PostRepository;
import com.tenzo.mini_project2.web.dto.myPageDto.MyPageRequestDto;
import com.tenzo.mini_project2.web.dto.myPageDto.MyPageResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<MyPageResponseDto> showMyPage(Long id) {
        List<MyPageResponseDto> myPageResponseDtoArrayList = new ArrayList<>();

        List<Post> postList = postRepository.findAllById(id);
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

    @Transactional
// FIXME: 2022/06/13 예외처리만 하면 될 거 같음.
    public Long update(Long id, MyPageRequestDto myPageRequestDto) {
        // FIXME: 2022/06/13 authe, princi  사용해보기.
        Post postFoundInDb = postRepository.findByIdAndUser(id, myPageRequestDto.getPostId());
        postFoundInDb = Post.builder()
                .title(myPageRequestDto.getTitle())
                .tags(myPageRequestDto.getTag())
                // FIXME: 2022/06/12 enum 이거 어떻게 하는 지 몰라서 넣어두기만 함. 맞는지 안 맞는지 불확실.
                .position(myPageRequestDto.getPosition())
                .build();

        postRepository.save(postFoundInDb);

        return id;
    }

    public Long delete(Long id, MyPageRequestDto myPageRequestDto) {
        // FIXME: 2022/06/13 authe, princi  사용해보기.
        Post postFoundInDb = postRepository.findPostByIdAndPostId(id, myPageRequestDto.getPostId());
        postRepository.delete(postFoundInDb);
        return id;
    }
}
