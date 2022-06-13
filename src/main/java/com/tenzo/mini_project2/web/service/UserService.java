package com.tenzo.mini_project2.web.service;

import com.tenzo.mini_project2.domain.respository.UserRepository;
import com.tenzo.mini_project2.security.model.User;
import com.tenzo.mini_project2.web.dto.userDto.UserRequestDto;
import com.tenzo.mini_project2.web.validator.UserValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserValidator userValidator;
    private final UserRepository userRepository;

    @Transactional
    public void enrollUser(UserRequestDto userRequestDto) {
        userValidator.checkEmailIsAlreadyInDb(userRequestDto.getEmail());
        userValidator.checkNickNameIsAleadyInDb(userRequestDto.getNickName());

        userValidator.checkNickNameIsMatchedWithPattern(userRequestDto.getNickName());
        userValidator.checkPasswordIsMatchedWithPattern(userRequestDto.getPassword());

        userValidator.checkElementIsNull(userRequestDto);

        User user = User.builder()
                .email(userRequestDto.getEmail())
                .nickname(userRequestDto.getNickName())
                .password(userRequestDto.getPassword())
                .build();

        userRepository.save(user);
    }

    @Transactional
    public void logInUser(UserRequestDto userRequestDto) {
        String email = userRequestDto.getEmail();
        String password = userRequestDto.getPassword();

        // FIXME: 2022/06/11 이거 정상 작동할까???
        userValidator.checkElementIsNull(userRequestDto);
        userValidator.checkEmailIsAlreadyInDb(userRequestDto.getEmail());

        // TODO: 2022/06/11 로그인 작업 해야 함.
    }
//        // FIXME: 2022/06/11 정상 작동 안 할수 있음.
//        if (user.isPresent()) {
//            String passwordInDb = String.valueOf(userRepository.findUserByNickNameAndPassword(userRequestDto.getNickName(), userRequestDto.getPassword()));
//            if (passwordInDb == userRequestDto.getPassword()) {
//                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//            }
//        }
}

