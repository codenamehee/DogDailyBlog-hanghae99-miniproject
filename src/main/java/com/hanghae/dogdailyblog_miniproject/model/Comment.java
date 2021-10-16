package com.hanghae.dogdailyblog_miniproject.model;

import com.hanghae.dogdailyblog_miniproject.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped {
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long commentid; // 댓글 인덱스 번호

    @Column(nullable = false)
    private Long postid; // 게시글 인덱스 번호

    @Column(nullable = false)
    private String userid; // 댓글 입력 유저의 닉네임

    @Column(nullable = false)
    private String comment; // 댓글 내용

    @Column(nullable = false)
    private Long userindex; // 댓글 입력 유저의 DB 인덱스번호

    public Comment(Long postid, String userid, String comment) {
        this.postid = postid;
        this.userid = userid;
        this.comment = comment;
    }

    public Comment(CommentRequestDto requestDto) {
        this.postid = requestDto.getPostid();
        this.comment = requestDto.getComment();
        this.userid = requestDto.getUserid();
    }

    public Comment(CommentRequestDto requestDto, Long userindex) {
        this.postid = requestDto.getPostid();
        this.comment = requestDto.getComment();
        this.userid = requestDto.getUserid();
        this.userindex = userindex;
    }

    public Comment(CommentRequestDto requestDto, Long userindex, String comment) {
        this.postid = requestDto.getPostid();
        this.comment = comment;
        this.userid = requestDto.getUserid();
        this.userindex = userindex;
    }

    public void update(CommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
    }
}