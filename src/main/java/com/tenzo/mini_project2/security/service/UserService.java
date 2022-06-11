package com.tenzo.mini_project2.security.service;


import com.tenzo.mini_project2.security.dto.UserRequestDto;
import com.tenzo.mini_project2.security.dto.UserResponseDto;
import com.tenzo.mini_project2.security.jwt.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDetailsServiceImpl service;
    private final JwtTokenProvider jwtTokenProvider;
    private final RedisTemplate<String, String> redisTemplate;

    public ResponseEntity<?> login(UserRequestDto.Login login) {
        UserDetailsImpl userDetails = (UserDetailsImpl) service.loadUserByUsername(login.getEmail());
        UserResponseDto.TokenInfo tokens = jwtTokenProvider.generateToken(userDetails);

        // 4. RefreshToken Redis 저장 (expirationTime 설정을 통해 자동 삭제 처리)
        setRedisTemplate(userDetails.getUsername(), tokens.getRefreshToken(), tokens.getRefreshTokenExpirationTime());
        return new ResponseEntity<>(tokens, HttpStatus.OK);
    }


    // 토큰 재발급
    public ResponseEntity<?> reIssuance(UserRequestDto.Reissue reissue){
        
        // refresh 토큰 검증
        if(!jwtTokenProvider.validateToken(reissue.getRefreshToken())){
            return new ResponseEntity<>("Refresh Token 정보가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
        UserDetails userDetails = jwtTokenProvider.getUserDetails(reissue.getAccessToken());

        // redis 에서 저장된 refresh 가져오기
        String refreshToken = redisTemplate.opsForValue().get("RT:"+userDetails.getUsername());
        if(ObjectUtils.isEmpty(refreshToken)){
            return new ResponseEntity<>("잘못된 요청입니다.", HttpStatus.BAD_REQUEST); 
        } else if (refreshToken.equals(reissue.getRefreshToken())) {
            return new ResponseEntity<>("Refresh Token 정보가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
        UserResponseDto.TokenInfo tokenInfo = jwtTokenProvider.generateToken((UserDetailsImpl) userDetails);
        setRedisTemplate(userDetails.getUsername(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime());

        return new ResponseEntity<>(tokenInfo, HttpStatus.OK);
    }

    //RefreshToken Redis 저장 (expirationTime 설정을 통해 자동 삭제 처리)
    public void setRedisTemplate(String username, String refreshToken, Long refreshTokenExpirationTime){
        redisTemplate.opsForValue()
                .set("RT:" + username, refreshToken, refreshTokenExpirationTime, TimeUnit.MILLISECONDS);
    }

    public ResponseEntity<?> logout(UserRequestDto.Logout logout) {
        // 1. Access Token 검증
        if (!jwtTokenProvider.validateToken(logout.getAccessToken())) {
            return new ResponseEntity<>("잘못된 요청입니다.", HttpStatus.BAD_REQUEST);
        }

        // 2. Access Token 에서 User email 을 가져옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(logout.getAccessToken());

        // 3. Redis 에서 해당 User email 로 저장된 Refresh Token 이 있는지 여부를 확인 후 있을 경우 삭제합니다.
        if (redisTemplate.opsForValue().get("RT:" + authentication.getName()) != null) {
            // Refresh Token 삭제
            redisTemplate.delete("RT:" + authentication.getName());
        }

        // 4. 해당 Access Token 유효시간 가지고 와서 BlackList 로 저장하기
        Long expiration = jwtTokenProvider.getExpiration(logout.getAccessToken());
        redisTemplate.opsForValue()
                .set(logout.getAccessToken(), "logout", expiration, TimeUnit.MILLISECONDS);

        return new ResponseEntity<>("로그아웃 되었습니다.", HttpStatus.OK);
    }
}
