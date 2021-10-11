package com.hanghae.dogdailyblog_miniproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CmtResponseDto {
    private Long id;

    private Long userId;
    private String username;
    private String comment;
    private String createdAt;
}
