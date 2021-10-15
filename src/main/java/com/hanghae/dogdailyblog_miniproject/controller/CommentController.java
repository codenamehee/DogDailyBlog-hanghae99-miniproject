package com.hanghae.dogdailyblog_miniproject.controller;

import com.hanghae.dogdailyblog_miniproject.model.Comment;
import com.hanghae.dogdailyblog_miniproject.dto.CommentRequestDto;
import com.hanghae.dogdailyblog_miniproject.repository.CommentRepository;
import com.hanghae.dogdailyblog_miniproject.security.UserDetailsImpl;
import com.hanghae.dogdailyblog_miniproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository CommentRepository;

    @GetMapping("/detail")
    public List<Comment> getComments(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long commentId = userDetails.getUser().getId();
        return CommentService.getComments(commentId);
    }

    //해당 게시물에 대한 모든 댓글
    @GetMapping("/detail/{postId}")
    public List<Comment> getComments(@PathVariable Long postId) {
        return commentService.getComments(postId);
    }

    //게시물에 댓글 달기
    @PostMapping("/detail/{id}")
    public Comment createComment(@RequestBody CommentRequestDto requestDto) {
        System.out.println("commentId: " + requestDto.getCommentId() + ", postId: " + requestDto.getPostId() +
                ", userid: " + requestDto.getUserid() + ", username" + requestDto.getUsername() + ", comment" + requestDto.getComment());
        return commentService.createComment(requestDto);
    }

    //댓글 수정
    @PutMapping("/detail/{id}")
    public Long updateComment(@PathVariable Long id,
                              @RequestBody CommentRequestDto requestDto) {
        System.out.println("commentId: " + requestDto.getCommentId() + ", postId: " + requestDto.getPostId() +
                ", userid: " + requestDto.getUserid() + ", username" + requestDto.getUsername() + ", comment" + requestDto.getComment());
        return commentService.updateComment(id, requestDto);
    }

//    //댓글삭제
//    @DeleteMapping("/detail/{id}")
//    public Long deleteComment(@PathVariable Long id) {
//        commentService.deleteComment(id);
//        return id;
//    }
}