package com.hanghae.dogdailyblog_miniproject.controller;

import com.hanghae.dogdailyblog_miniproject.dto.CmtRequestDto;
import com.hanghae.dogdailyblog_miniproject.model.Cmt;
import com.hanghae.dogdailyblog_miniproject.security.UserDetailsImpl;
import com.hanghae.dogdailyblog_miniproject.service.CmtService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api(tags={"댓글 관련 APi"})
public class CmtController {
    private final CmtService cmtService;


    // Create
    @PostMapping("/detail/save")
    public Cmt commentSave(@RequestBody @ModelAttribute CmtRequestDto cmtRequestDto,
                           @AuthenticationPrincipal UserDetailsImpl userDetails
    ){
        Cmt saveCmt = cmtService.save(cmtRequestDto, userDetails);

        return saveCmt;
    }

    // Update
    @PutMapping("/detail/update")
    public Cmt commentUpdate(@RequestParam Long id, @RequestBody @ModelAttribute CmtRequestDto cmtRequestDto){
        Cmt updateComment = cmtService.update(id, cmtRequestDto);

        return updateComment;
    }


    // Delete
    @GetMapping("/detail/delete")
    public void deletePost(@RequestParam(value = "id", required = true)Long id){
        cmtService.delete(id);

    }

}