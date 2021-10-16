package com.hanghae.dogdailyblog_miniproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
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

