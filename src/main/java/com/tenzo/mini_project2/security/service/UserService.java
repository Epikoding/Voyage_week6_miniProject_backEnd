package com.tenzo.mini_project2.security.service;


import com.tenzo.mini_project2.security.UserDetailsImpl;
import com.tenzo.mini_project2.security.dto.HeaderResponseDto;
import com.tenzo.mini_project2.security.dto.LoginRequestDto;
import com.tenzo.mini_project2.security.dto.RefreshTokenInfo;
import com.tenzo.mini_project2.security.dto.SignupRequestDto;
import com.tenzo.mini_project2.security.jwt.JwtTokenProvider;
import com.tenzo.mini_project2.security.model.User;
import com.tenzo.mini_project2.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_TYPE = "Bearer";
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    private final RedisTemplate<String, Object> redisTemplate;

    // 로그인
    public void login(LoginRequestDto dto, HttpServletResponse response) {

        User user = userRepository.findUserByEmail(dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀립니다.");
        }
        HeaderResponseDto headerResponseDto = jwtTokenProvider.createToken(user.getEmail());
        setRedisTemplate(user.getEmail(), headerResponseDto.getREFRESH_TOKEN(), headerResponseDto.getRefreshTokenExpirationTime());
        addMultiHeader(response, headerResponseDto);
    }

    // 회원가입
    public ResponseEntity<?> signup(SignupRequestDto dto) {

        if (dto == null) {
            throw new IllegalArgumentException("회원가입 실패");
        } else if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("아이디가 존재합니다.");
        } else if (userRepository.existsByNickname(dto.getNickname())) {
            throw new IllegalArgumentException("닉네임이 존재합니다.");
        } else {
            dto.setPassword(encoder.encode(dto.getPassword()));
        }
        return new ResponseEntity<>(userRepository.save(new User(dto)), HttpStatus.OK);
    }

    public void reIssuance(UserDetailsImpl userDetails, HttpServletRequest request, HttpServletResponse response) {

        RefreshTokenInfo tokenInfo = jwtTokenProvider.resolveRefreshToken(request);
        // refresh 토큰 검증
        if (!jwtTokenProvider.validateToken(tokenInfo.getREFRESH_TOKEN())) {
            throw new RuntimeException("Refresh Token 정보가 일치하지 않습니다.");
        }

        // redis 에서 저장된 refresh 가져오기
        String refreshToken = (String) redisTemplate.opsForValue().get("RT:" + userDetails.getUsername());
        if (ObjectUtils.isEmpty(refreshToken)) {
            throw new RuntimeException("잘못된 요청입니다.");
        } else if (refreshToken.equals(tokenInfo.getREFRESH_TOKEN())) {
            throw new RuntimeException("Refresh Token 정보가 일치하지 않습니다.");
        }

        HeaderResponseDto headerDto = jwtTokenProvider.createToken(userDetails.getUsername());
        setRedisTemplate(userDetails.getUsername(), tokenInfo.getREFRESH_TOKEN(), tokenInfo.getRefreshTokenExpirationTime());
        addMultiHeader(response, headerDto);
    }


    public ResponseEntity<?> logout(HttpServletRequest request) {
        // 1. Access Token 검증
        String token = jwtTokenProvider.resolveToken(request);
        if (!jwtTokenProvider.validateToken(token)) {
            throw new RuntimeException("잘못된 요청입니다.");
        }

        // 2. Access Token 에서 User email 을 가져옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(token);

        // 3. Redis 에서 해당 User email 로 저장된 Refresh Token 이 있는지 여부를 확인 후 있을 경우 삭제.
        if (redisTemplate.opsForValue().get("RT:" + authentication.getName()) != null) {
            // Refresh Token 삭제
            redisTemplate.delete("RT:" + authentication.getName());
        }

        //4. logout accessToken manage
        Long expiration = jwtTokenProvider.getExpiration(token);
        redisTemplate.opsForValue()
                .set(token, "logout", expiration, TimeUnit.MILLISECONDS);

        return new ResponseEntity<>("로그아웃 되었습니다.", HttpStatus.OK);
    }

    // refreshToken store
    public void setRedisTemplate(String username, String refreshToken, Long refreshTokenExpirationTime) {
        redisTemplate.opsForValue()
                .set("RT:" + username, refreshToken, refreshTokenExpirationTime, TimeUnit.MILLISECONDS);
    }

    //tokens add header
    public void addMultiHeader(HttpServletResponse response, HeaderResponseDto headerResponseDto) {
        response.addHeader(AUTHORIZATION_HEADER, BEARER_TYPE + " " + headerResponseDto.getACCESS_TOKEN());
        response.addHeader("RefreshToken", BEARER_TYPE + " " + headerResponseDto.getREFRESH_TOKEN());
        response.addHeader("RefreshTokenExpirationTime", String.valueOf(headerResponseDto.getRefreshTokenExpirationTime()));
    }

}