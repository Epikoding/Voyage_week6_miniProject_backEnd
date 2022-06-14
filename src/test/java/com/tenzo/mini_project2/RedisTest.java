package com.tenzo.mini_project2;

import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.domain.respository.PostRepository;
import com.tenzo.mini_project2.web.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisTest {

    @Autowired
    PostService service;
    @Test
    void post() {
       Post post =  Post.builder()
        .imgUrl("TEST")
        .position("top")
        .title("test")
        .tagList("#TEST")
        .nickName("test")
        .build();


}


}
