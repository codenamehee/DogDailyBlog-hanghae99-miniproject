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
    private Long postId;    //게시물번호
    private Long commentId;    //사용자 번호
    private String userid;      //사용자 이름
    private String comment; //댓글내용
    private String username;
}