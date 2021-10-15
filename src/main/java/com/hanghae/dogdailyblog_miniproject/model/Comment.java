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
    private Long postid;

    @Column(nullable = false)
    private Long commentid;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;

    public Comment(Long commentid, String username, String comment) {
        this.commentid = commentid;
        this.username = username;
        this.comment = comment;
    }

    public Comment(CommentRequestDto requestDto) {
        this.commentid = requestDto.getCommentid();
        this.username = requestDto.getUsername();
        this.comment = requestDto.getComment();
    }
    public Comment(CommentRequestDto requestDto, Long commentid){
        this.commentid = commentid;
        this.username = requestDto.getUsername();
        this.comment = requestDto.getComment();
    }

    public void update(CommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
    }
}