package com.hanghae.dogdailyblog_miniproject.controller;

import com.hanghae.dogdailyblog_miniproject.dto.SignupRequestDto;
import com.hanghae.dogdailyblog_miniproject.dto.UserRequestDto;
import com.hanghae.dogdailyblog_miniproject.model.User;
import com.hanghae.dogdailyblog_miniproject.repository.UserRepository;
import com.hanghae.dogdailyblog_miniproject.security.JwtTokenProvider;
import com.hanghae.dogdailyblog_miniproject.service.UserService;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder, UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // 회원 가입 요청 처리(유효성 검사 포함)
    @PostMapping("/user/signup")
    @ResponseBody
    public void registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
    }

    //로그인
    @PostMapping("/user/login")
    public Map<String,String> login(@RequestBody UserRequestDto requestDto) {

        User user = userRepository.findByUserid(requestDto.getUserid())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 유저입니다."));
        // matches뒤에 순서가 중요함(첫번째가 로우패스워드, 두번째가 인코드되어 저장되어있는 패스워드)
        if (!passwordEncoder.matches(requestDto.getPwd(), user.getPwd())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        Map<String,String> result =new HashMap<>();
        result.put("token",jwtTokenProvider.createToken(user.getUserid(), user.getUserid())); // "username" : {username}


        return result;
    }
}