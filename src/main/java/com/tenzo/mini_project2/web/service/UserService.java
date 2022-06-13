//package com.tenzo.mini_project2.web.service;
//
//import com.tenzo.mini_project2.domain.models.User;
//import com.tenzo.mini_project2.domain.respository.UserRepository;
//import com.tenzo.mini_project2.web.dto.UserDto;
//import com.tenzo.mini_project2.web.validator.UserValidator;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//import java.util.regex.Pattern;
//
//@Service
//
//public class UserService {
//    private final UserValidator userValidator;
//    private final UserRepository userRepository;
//
//
//    public UserService(UserValidator userValidator, UserRepository userRepository) {
//        this.userValidator = userValidator;
//        this.userRepository = userRepository;
//    }
//
//    public User enrollUser(UserDto userDto) {
//        userValidator.checkIfThereIsTheUser(userDto.getEmail());
//
//        Optional<User> nickNameInDb =
//        String email = userDto.getEmail();
//        String nickName = userDto.getNickName();
//        String password = userDto.getPassword();
//
//        String nickNamePattern = "^[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣0-9]{5,20}$"; // 소문자, 대문자, 한글, 숫자를 5~20자 내로 가능
//        String passwordPattern = "^[a-zA-Z0-9]{4,30}$"; //소문자, 대문자, 숫자를 4~30자 내로 사용 가능.
//
//        boolean isNickNameTrue = Pattern.matches(nickNamePattern, userDto.getNickName());
//        boolean isPasswordTrue = Pattern.matches(passwordPattern, userDto.getPassword());
//
//        // 중복된 닉네임이 있다면
//        if (usernameInDb.isPresent()) {
//            throw new IllegalArgumentException("중복된 사용자 닉네임이 존재합니다.");
//        }
//        // 두개의 비밀번호가 동일하지 않다면
//        if (!password.equals(password2)) {
//            throw new IllegalArgumentException("비밀번호가 동일하지 않습니다.");
//        }
//        // 비밀번호의 조건이 충족하지 않다면
//        if (!isUsernameTrue) {
//            throw new IllegalArgumentException("아이디가 형식에 맞지 않습니다.");
//        }
//        if (!isPasswordTrue) {
//            throw new IllegalArgumentException("비밀번호가 형식에 맞지 않습니다.");
//        }
//        if (username == null) {
//            throw new IllegalArgumentException("아이디를 입력해주세요.");
//        }
//
//
//        return null;
//    }
//}
