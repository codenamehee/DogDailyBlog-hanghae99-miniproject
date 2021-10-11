package com.hanghae.dogdailyblog_miniproject.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String userid;
    private String username;
    private String pwd;
}
