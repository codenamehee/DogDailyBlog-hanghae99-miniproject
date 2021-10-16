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

    private final CommentRepository CommentRepository;

    // 댓글 조회
    public List<Comment> getComment(Long postid) {
        return CommentRepository.findAllByPostidOrderByModifiedAtDesc(postid);
    }

    // 댓글 작성
    @Transactional
    public Comment createComment(CommentRequestDto requestDto, Long userindex) {
        String commentCheck = requestDto.getComment();
        if (commentCheck.contains("script")|| commentCheck.contains("<")||commentCheck.contains(">")){
            Comment comment = new Comment(requestDto, userindex, "xss 안돼요,, 하지마세요ㅠㅠ");
            CommentRepository.save(comment);
            return comment;
        }
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        System.out.println(requestDto.getUserid() + "객체 생성 전 userid");
        Comment comment = new Comment(requestDto, userindex);
        System.out.println(requestDto.getUserid() + "테이블 저장 전 userid");
        CommentRepository.save(comment);
        return comment;
    }

    // 댓글 수정
    @Transactional
    public void update(Long postid, CommentRequestDto requestDto) {
        Comment comment = CommentRepository.findById(postid).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않습니다.")
        );
        comment.update(requestDto);
    }
}