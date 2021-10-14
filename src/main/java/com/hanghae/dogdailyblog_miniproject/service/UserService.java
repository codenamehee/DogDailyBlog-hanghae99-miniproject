package com.hanghae.dogdailyblog_miniproject.service;

import com.hanghae.dogdailyblog_miniproject.exception.ApiRequestException;
import com.hanghae.dogdailyblog_miniproject.model.User;
import com.hanghae.dogdailyblog_miniproject.dto.SignupRequestDto;
import com.hanghae.dogdailyblog_miniproject.dto.UserRequestDto;
import com.hanghae.dogdailyblog_miniproject.exception.ApiRequestException;
import com.hanghae.dogdailyblog_miniproject.repository.UserRepository;
import com.hanghae.dogdailyblog_miniproject.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
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

    // 토큰 생성
//    public String createToken(UserRequestDto user) {
//        System.out.println("서비스에서 토큰 생성");
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(user.getUserid(), user.getPwd());
//        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//        return jwtTokenProvider.createToken(authentication);
//    }
}