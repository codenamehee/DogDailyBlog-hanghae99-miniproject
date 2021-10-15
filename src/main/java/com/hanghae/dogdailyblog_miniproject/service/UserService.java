package com.hanghae.dogdailyblog_miniproject.service;

import com.hanghae.dogdailyblog_miniproject.model.User;
import com.hanghae.dogdailyblog_miniproject.dto.SignupRequestDto;
import com.hanghae.dogdailyblog_miniproject.repository.UserRepository;
import com.hanghae.dogdailyblog_miniproject.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public void registerUser(SignupRequestDto requestDto) {

        String userid = requestDto.getUserid();

        String username = requestDto.getUsername();

//        Optional<User> found = userRepository.findByUsername(username);
//        if (found.isPresent()) {
//            throw new ApiRequestException("중복된 사용자 ID 가 존재합니다.");
//        }

        String password = requestDto.getPwd();
        password = passwordEncoder.encode(password);

        User user = new User(userid, username, password);
        userRepository.save(user);

    }

    // 토큰에서

}