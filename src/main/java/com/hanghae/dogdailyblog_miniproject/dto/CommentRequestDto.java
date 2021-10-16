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
    private Long postid;    // 댓글 달 게시글 번호
    private String comment; // 댓글 내용
    private String userid; // 댓글 작성자의 아이디(로그인된 아이디)
    private Long userindex; // 댓글 작성자의 DB 인덱스 번호
}
//////댓글 필요 사항/////////
// 게시글 id로 댓글 조회 contentId
// 댓글 작성자의 닉네임 commentusername
// 댓글 내용 comment
// 댓글 수정, 삭제 시 유저 조회에 필요한 DB에 저장되어 있는 유저별 인덱스 commentid

// 댓글 작성 로직
// 게시글 아이디로 게시글 조회 -> 댓글 작성(댓글 내용, 작성자이름) ->