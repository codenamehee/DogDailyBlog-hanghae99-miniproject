package com.hanghae.dogdailyblog_miniproject.service;

import com.hanghae.dogdailyblog_miniproject.dto.CommentRequestDto;
import com.hanghae.dogdailyblog_miniproject.model.Comment;
import com.hanghae.dogdailyblog_miniproject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

   //---------------------------작동해야할것들-----------------------------------

    public List<Comment> getComments(Long postid) {
        return commentRepository.findAllByPostidOrderByCreatedAtDesc(postid);
    }

    @Transactional
    public Comment createComment(CommentRequestDto requestDto, String userid) {
        Comment comment = new Comment(requestDto, userid);
        return commentRepository.save(comment);
    }


    //---------------------------------------------------------------------------


//    @Transactional
//    public Long updateComment(Long id, CommentRequestDto requestDto) {
//        Comment comment = commentRepository.findById(id).orElseThrow(
//                () -> new NullPointerException("CommentService) DB에 아이디값이 없습니다.")
//        );
//        comment.update(requestDto);
//        return comment.getId();
//    }
//
//    @Transactional
//    public Long deleteComment(Long id) {
//        commentRepository.deleteById(id);
//        return id;
//    }
}