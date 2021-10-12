package com.hanghae.dogdailyblog_miniproject.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String userid;
    private String username;
    private String pwd;

    public SignupRequestDto(String userid, String username, String pwd) {
        this.userid = userid;
        this.username = username;
        this.pwd = pwd;
    }
}
