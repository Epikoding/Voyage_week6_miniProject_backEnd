package com.tenzo.mini_project2.web.validator;

import com.tenzo.mini_project2.security.model.User;
import com.tenzo.mini_project2.security.repository.UserRepository;
import com.tenzo.mini_project2.web.dto.userDto.UserRequestDto;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Pattern;

//@Component
//public class UserValidator {
//    private final UserRepository userRepository;
//
//    public UserValidator(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    // 중복된 이메일 주소가 있다면
//    public void checkEmailIsAlreadyInDb(String email) {
//        Optional<User> user = userRepository.findUserByEmail(email);
//        if (user.isPresent()) {
//            throw new IllegalArgumentException("이미 존재하는 이메일 주소입니다.");
//        }
//    }
//
//    // 중복된 닉네임이 있다면
//    public void checkNickNameIsAleadyInDb(String nickName) {
//        Optional<User> user = userRepository.findUserByNickName(nickName);
//        if (user.isPresent()) {
//            throw new IllegalArgumentException("중복된 사용자 닉네임이 존재합니다.");
//        }
//    }
//
//    // 비밀번호의 조건이 충족하지 않다면
//    public void checkPasswordIsMatchedWithPattern(String password) {
//        String passwordPattern = "^[a-zA-Z0-9]{4,30}$"; //소문자, 대문자, 숫자를 4~30자 내로 사용 가능.
//        boolean isPasswordTrue = Pattern.matches(passwordPattern, password);
//
//        if (!isPasswordTrue) {
//            throw new IllegalArgumentException("비밀번호가 형식에 맞지 않습니다.");
//        }
//    }
//
//    // 닉네임 조건이 충족하지 않다면
//    public void checkNickNameIsMatchedWithPattern(String nickName) {
//        String nickNamePattern = "^[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣0-9]{5,20}$"; // 소문자, 대문자, 한글, 숫자를 5~20자 내로 가능
//        boolean isNickNameTrue = Pattern.matches(nickNamePattern, nickName);
//
//        if (!isNickNameTrue) {
//            throw new IllegalArgumentException("닉네임이 형식에 맞지 않습니다.");
//        }
//    }
//
//    public void checkElementIsNull(UserRequestDto userRequestDto) {
//        // 이메일이 공란이면
//        if (userRequestDto.getEmail() == null) {
//            throw new IllegalArgumentException("이메일를 입력해주세요.");
//        }
//        // 닉네임이 공란이면
//        if (userRequestDto.getNickName() == null) {
//            throw new IllegalArgumentException("닉네임을 입력해주세요.");
//        }
//        // 비밀번호이 공란이면
//        if (userRequestDto.getPassword() == null) {
//            throw new IllegalArgumentException("비밀번호를 입력해주세요.");
//        }
//    }
//}
