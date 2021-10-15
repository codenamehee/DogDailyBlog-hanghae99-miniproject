package com.hanghae.dogdailyblog_miniproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDto {
    private Long commentid;    //게시물번호
    private String comment;
    private String username; //작성자
}