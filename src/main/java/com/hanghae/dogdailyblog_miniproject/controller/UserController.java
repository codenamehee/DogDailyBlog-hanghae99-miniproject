package com.hanghae.dogdailyblog_miniproject.controller;

import com.hanghae.dogdailyblog_miniproject.dto.SignupRequestDto;
import com.hanghae.dogdailyblog_miniproject.dto.UserRequestDto;
import com.hanghae.dogdailyblog_miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 유효성 없는 회원가입 처리
    @PostMapping("/user/signup")
    @ResponseBody
    public String registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "redirect:/user/signup";
    }

    @PostMapping("/user")
    public String login(@RequestBody UserRequestDto user) {
        return userService.createToken(user);
    }
}

// 회원 가입 요청 처리(유효성 검사 포함)
//    @PostMapping("/user/signup")
//    @ResponseBody
//    public String registerUser(@Valid @RequestBody SignupRequestDto requestDto, Errors errors, Model model) {
//       if(errors.hasErrors()) {
//           model.addAttribute("requestDto", requestDto);
//
//           Map<String, String> validatorResult = userService.validateHandling(errors);
//           for(String key : validatorResult.keySet()) {
//               model.addAttribute(key, validatorResult.get(key));
//           }
//
//           return "/user/signup";
//       }
//
//        userService.registerUser(requestDto);
//        return "redirect:/user/signup";
//    }

// 로그인
//    @GetMapping("/user/login")
//    public String login() {
//        return "redirect:/";
//    }