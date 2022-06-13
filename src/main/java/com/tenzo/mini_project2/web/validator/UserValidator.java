package com.tenzo.mini_project2.web.validator;

import com.tenzo.mini_project2.security.model.User;
import com.tenzo.mini_project2.security.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserValidator {
    private final UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void checkIfThereIsTheUser(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일 주소입니다.");
        }
    }




}
