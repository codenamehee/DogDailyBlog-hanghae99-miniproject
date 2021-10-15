package com.hanghae.dogdailyblog_miniproject.model;

import com.hanghae.dogdailyblog_miniproject.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;            //댓글번호

    @Column(nullable = false)
    private Long postId;        //게시물번호

    @Column(nullable = false)
    private Long commentId;        //사용자 번호

    @Column(nullable = false)
    private String userid;          //사용자 이름

    @Column(nullable = false)
    private String username;          //사용자 이름

    @Column
    private String comment;     //댓글내용

    public Comment(CommentRequestDto requestDto) {
        //this.id = requestDto.getId();
        this.postId = requestDto.getPostId();
        this.commentId = requestDto.getCommentId();
        this.username = requestDto.getUsername();
        this.comment = requestDto.getComment();
        this.userid = requestDto.getUserid();
    }

    public void update(CommentRequestDto requestDto) {
        this.postId = requestDto.getPostId();
        this.commentId = requestDto.getCommentId();
        this.username = requestDto.getUsername();
        this.comment = requestDto.getComment();
        this.userid = requestDto.getUserid();
    }
}