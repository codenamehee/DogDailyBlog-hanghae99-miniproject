package com.hanghae.dogdailyblog_miniproject.service;

import com.hanghae.dogdailyblog_miniproject.dto.CmtRequestDto;
import com.hanghae.dogdailyblog_miniproject.model.Cmt;
import com.hanghae.dogdailyblog_miniproject.model.Contents;
import com.hanghae.dogdailyblog_miniproject.repository.CmtRepository;
import com.hanghae.dogdailyblog_miniproject.repository.ContentsRepository;
import com.hanghae.dogdailyblog_miniproject.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CmtServiceImpl implements CmtService{
    private final CmtRepository commentRepository;
    private final ContentsRepository contentsRepository;

    @Override
    public Cmt save(CmtRequestDto commentRequestDto, UserDetailsImpl userDetails) {
        Contents findContents = contentsRepository.findById(commentRequestDto.getContentsId()).orElseThrow(
                () -> new NullPointerException("같은 아이디의 게시글이 없습니다.")
        );

        Cmt newComment = new Cmt(commentRequestDto.getComment(), findContents, userDetails.getUser());

        Cmt saveComment = commentRepository.save(newComment);

        return saveComment;
    }

    @Override
    public List<CmtRequestDto> findAll() {
        return null;
    }

    @Override
    public Cmt findById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Cmt update(Long id, CmtRequestDto commentRequestDto) {
        Cmt findComment = commentRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당하는 아이디의 댓글이 없습니다.")
        );

        findComment.update(commentRequestDto);

        return findComment;
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
