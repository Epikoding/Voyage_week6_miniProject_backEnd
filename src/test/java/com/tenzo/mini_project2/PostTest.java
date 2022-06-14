package com.tenzo.mini_project2;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private HttpHeaders headers;
    private ObjectMapper mapper = new ObjectMapper();

    private UserRequestDto userRequestDto;

    private PostRequestDto postRequestDto1 = PostRequestDto.builder()
            .title("test1")
            .content("test1")
            .imgUrl("test1")
            .tags("test1")
            .position("test1")
            .build();

    private PostRequestDto postRequestDto2 = PostRequestDto.builder()
            .title("test2")
            .content("test2")
            .imgUrl("test2")
            .tags("test2")
            .position("test2")
            .build();

    private PostRequestDto postRequestDto3 = PostRequestDto.builder()
            .title("test3")
            .content("test3")
            .imgUrl("test3")
            .tags("test3")
            .position("test3")
            .build();

    @BeforeEach
    public void setup() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    @Order(1)
    @DisplayName("포스터1 등록")
    void test1() throws JsonProcessingException {
        // given
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .id(null)
                .email("test@gmail.com")
                .password("test1")
                .nickName("test1")
                .build();

        String requestBody = mapper.writeValueAsString(userRequestDto);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        // when
        ResponseEntity<UserRequestDto> response = restTemplate.postForEntity(
                "/user/signup",
                request,
                UserRequestDto.class);

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());

//        UserRequestDto userRequestDto = response.getBody();
        assertNotNull(userRequestDto);
        assertTrue(userRequestDto.id > 0);
        assertNotNull(userRequestDto.email);
        assertNotNull(userRequestDto.password);
        assertNotNull(userRequestDto.nickName);


        // 음식점 등록 성공 시, registeredRestaurant 에 할당
        registeredRestaurant = restaurantResponse;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class CommentDto {
        private Long userId;
        private Long postId;
        private String comment;
    }

    @Getter
    public class MyPageRequestDto {
        private Long postId;
        private String title;
        private String content;
        private String tags;
        private String position;
    }

    @Getter
    @Setter
    @Builder
    public class MyPageResponseDto {
        private Long userId;
        private Long postId;
        private String title;
        private String contents;
        private String imgUrl;
        private String position;

    }

    @Getter
    @Builder
    public class PostRequestDto {

        private String title;
        private String content;
        private String imgUrl;
        private String tags;
        private String position;

    }

    @Getter
    @Builder
    public class UserRequestDto {
        private Long id;
        private String email;
        private String password;
        private String nickName;
    }


}
