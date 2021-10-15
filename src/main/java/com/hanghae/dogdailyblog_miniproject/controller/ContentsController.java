package com.hanghae.dogdailyblog_miniproject.controller;

import com.hanghae.dogdailyblog_miniproject.dto.ContentsRequestDto;
import com.hanghae.dogdailyblog_miniproject.model.Contents;
import com.hanghae.dogdailyblog_miniproject.repository.ContentsRepository;
import com.hanghae.dogdailyblog_miniproject.security.UserDetailsImpl;
import com.hanghae.dogdailyblog_miniproject.service.ContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.filechooser.FileSystemView;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ContentsController {

    private final ContentsRepository ContentsRepository;
    private final ContentsService ContentsService;


    @GetMapping("/")
    public List<Contents> getContents(){
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
    public Contents createContents(@RequestBody ContentsRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDatails){
        //로그인 되어 있는 ID의 userid
        String userid = userDatails.getUser().getUsername();
        Contents contents = ContentsService.createContents(requestDto, userid);
        return contents;
    }

    //게시물 수정
    @PutMapping("/write/{id}")
    public Long updateContents(@PathVariable Long id, @RequestBody ContentsRequestDto requestDto){
        ContentsService.update(id,requestDto);
        return id;
    }

    //게시글 삭제
    @DeleteMapping("/write/{id}")
    public Long deletContents(@PathVariable Long id){
        ContentsRepository.deleteById(id);
        return id;
    }


}

