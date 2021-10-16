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
    private final CommentRepository commentRepository;

    @GetMapping("/detail")
    public List<Comment> getReply(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long postid = userDetails.getUser().getId();
        return commentService.getComment(postid);
    }

    // 게시글 id 로 댓글 조회
    @GetMapping("/detail/{postid}")
    public List<Comment> getComment(@PathVariable Long postid) {
        return commentService.getComment(postid);
    }

    // 댓글 작성
    @PostMapping("/detail/{postid}")
    public List<Comment> createComment(@RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long postid) {
        // 로그인 되어 있는 ID
        System.out.println(userDetails.getUser().getId());
        System.out.println(requestDto.getUserid());
        if (userDetails != null) {
            Long userindex = userDetails.getUser().getId();
            commentService.createComment(requestDto, userindex);
            return commentRepository.findAllByPostidOrderByModifiedAtDesc(postid);
        }
        return commentRepository.findAllByPostidOrderByModifiedAtDesc(postid);
    }

    // 댓글 수정
    @PutMapping("/detail/{postid}")
    public Long updateComment(@PathVariable Long postid, @RequestBody CommentRequestDto requestDto) {
        commentService.update(postid, requestDto);
        return postid;
    }

    // 댓글 삭제
//    @DeleteMapping("/detail/{postid}")
//    public List<Comment> deleteComment(@PathVariable Long postid) {
//        commentRepository.deleteById(postid);
//        return commentService.getComment(postid);
//    }

    // 댓글 삭제
//    @DeleteMapping("/detail/{commentid}")
//    public List<Comment> deleteComment(@PathVariable Long commentid, Long postid) {
//        commentRepository.deleteById(commentid);
//        return commentRepository.findAllByPostidOrderByModifiedAtDesc(postid);
//    }

    // 댓글 삭제 2
    @DeleteMapping("/detail/{commentid}")
    public List<Comment> deleteComment(@PathVariable Long commentid, @RequestBody CommentRequestDto requestDto) {
        Long postid = requestDto.getPostid();
        commentRepository.deleteById(commentid);
        return commentRepository.findAllByPostidOrderByModifiedAtDesc(postid);
    }
}

    //댓글 수정
//    @PutMapping("/detail/{id}")
//    public Long updateComment(@PathVariable Long id,
//                              @RequestBody CommentRequestDto requestDto) {
//        System.out.println("id: " + id + ", userId: " + requestDto.getUserId() + ", postId: " + requestDto.getPostId() +
//                ", name: " + requestDto.getName() + ", comment: " + requestDto.getComment());
//
//        return commentService.updateComment(id, requestDto);
//    }

    //댓글삭제
//    @DeleteMapping("/detail/{id}")
//    public Long deleteComment(@PathVariable Long id) {
//        commentService.deleteComment(id);
//        return id;
//    }
//}