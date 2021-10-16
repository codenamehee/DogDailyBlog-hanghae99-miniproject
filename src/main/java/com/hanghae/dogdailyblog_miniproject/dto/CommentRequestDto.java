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
    //private Long id;        //댓글번호
    private Long postId;    //게시물번호
    private Long userId;    //사용자 번호
    private String name;      //사용자 이름
    private String comment; //댓글내용

}

//////댓글 필요 사항/////////
// 게시글 id로 댓글 조회 contentId
// 댓글 작성자의 닉네임 commentusername
// 댓글 내용 comment
// 댓글 수정, 삭제 시 유저 조회에 필요한 DB에 저장되어 있는 유저별 인덱스 commentid

// 댓글 작성 로직
// 게시글 아이디로 게시글 조회 -> 댓글 작성(댓글 내용, 작성자이름) ->