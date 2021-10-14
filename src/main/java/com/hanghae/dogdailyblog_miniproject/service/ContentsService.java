package com.hanghae.dogdailyblog_miniproject.service;

import com.hanghae.dogdailyblog_miniproject.dto.ContentsRequestDto;
import com.hanghae.dogdailyblog_miniproject.model.Contents;
import com.hanghae.dogdailyblog_miniproject.repository.ContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ContentsService {
    private final ContentsRepository ContentsRepository;

    @Transactional //메소드 동작을 쿼리문임을 선언
    public Contents createContents(ContentsRequestDto requestDto, String username) {
        String contentsCheck = requestDto.getContents();
        String titleCheck = requestDto.getTitle();
        if (contentsCheck.contains("script") || contentsCheck.contains("<") || contentsCheck.contains(">")) {
            Contents contents = new Contents(requestDto, username, "xss 멈춰!");
            ContentsRepository.save(contents);
            return contents;
        }
        if (titleCheck.contains("script") || titleCheck.contains("<") || titleCheck.contains(">")){
            Contents contents = new Contents("xss 멈춰",username, " ", " ","xss 멈춰");
            ContentsRepository.save(contents);
            return contents;
        }
        // 요청받은 DTO로 저장할 객체만들기
        Contents contents = new Contents(requestDto, username);
        ContentsRepository.save(contents);
        return contents;
    }

    @Transactional //메소드 동작을 쿼리문임을 선언
    public Long update(Long id, ContentsRequestDto requestDto){
        Contents Contents = ContentsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        Contents.update(requestDto);
        return Contents.getId();
    }
}
