package com.hanghae.dogdailyblog_miniproject.dto;

import lombok.Getter;

@Getter
public class ContentsRequestDto {
    private String title; // 제목
    private String username;// 이름
    private String userid; // id
    private String contents; // 내용
    private String imageurl; // 이미지 주소
}

