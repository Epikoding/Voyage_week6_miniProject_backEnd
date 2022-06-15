package com.tenzo.mini_project2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.security.dto.SignupRequestDto;
import com.tenzo.mini_project2.security.model.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntegrationTest {

//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    private ObjectMapper mapper = new ObjectMapper();
//    private HttpHeaders headers;
//
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
//
//
//    @BeforeEach
//    public void setup() {
//        headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//    }

//    @Nested
//    class signupTest {
//
//        @Test
//        @Order(1)
//        @DisplayName("회원가입 성공")
//        void 회원가입() throws JsonProcessingException {
//
//            //given
//            String payload = mapper.writeValueAsString(user1);
//            HttpEntity<String> request = new HttpEntity<>(payload, headers);
//
//            //when
//            ResponseEntity<String> response = restTemplate.postForEntity(
//                    "/user/signup",
//                    request,
//                    User.class
//            );
//
//            //then
//            assertEquals(HttpStatus.OK, response.getStatusCode());
//            User user = response.getBody();
//            assertNotNull(user);
//            assertTrue(user.getId() > 0);
//            assertEquals(user.getNickname(), user1.getNickname());
//            assertEquals(user.getEmail(), user1.getEmail());
//
//
//
//        }


//        @Test
//        @Order(1)
//        @DisplayName("로그인 성공")
//        void 로그인() throws JsonProcessingException {
//
//            //given
//            String payload = mapper.writeValueAsString(user1);
//            HttpEntity<String> request = new HttpEntity<>(payload, headers);
//
//            //when
//            ResponseEntity<User> response = restTemplate.postForEntity(
//                    "/user/signup",
//                    request,
//                    User.class
//            );
//
//            //then
//            assertEquals(HttpStatus.OK, response.getStatusCode());
//            User user = response.getBody();
//            assertNotNull(user);
//            assertTrue(user.getId() > 0);
//            assertEquals(user.getNickname(), user1.getNickname());
//            assertEquals(user.getEmail(), user1.getEmail());
//        }
//    }

    }



