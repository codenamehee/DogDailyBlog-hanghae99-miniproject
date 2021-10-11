package com.hanghae.dogdailyblog_miniproject.controller;

import com.hanghae.dogdailyblog_miniproject.dto.ContentsRequestDto;
import com.hanghae.dogdailyblog_miniproject.model.Contents;
import com.hanghae.dogdailyblog_miniproject.repository.ContentsRepository;
import com.hanghae.dogdailyblog_miniproject.service.ContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ContentsController {

    private final ContentsRepository ContentsRepository;
    private final ContentsService ContentsService;

    //메인페이지 게시글 조회
    @GetMapping("/write")
    public List<Contents> getContets(){
        return ContentsRepository.findAllByOrderByCreatedAtDesc();
    }

    //개별 게시물 조회
    @GetMapping("/write/{id}")
    public Contents getContents(@PathVariable Long id){
        Contents contents = ContentsRepository.findById(id).orElseThrow(
                () ->new IllegalArgumentException("id가 존재하지 않습니다."));
        return contents;
    }
    //게시물 생성
    @PostMapping("/write")
    public Contents createContents(@RequestBody ContentsRequestDto requestDto){
        Contents contents = new Contents(requestDto);
        return ContentsRepository.save(contents);
    }
}

