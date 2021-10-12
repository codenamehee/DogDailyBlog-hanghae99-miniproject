package com.hanghae.dogdailyblog_miniproject.service;

import com.hanghae.dogdailyblog_miniproject.dto.CmtRequestDto;
import com.hanghae.dogdailyblog_miniproject.model.Cmt;
import com.hanghae.dogdailyblog_miniproject.security.UserDetailsImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CmtService {
    // Create
    public Cmt save(CmtRequestDto commentRequestDto, UserDetailsImpl userDetails);
    // Read All
    public List<CmtRequestDto> findAll();
    // Read One
    public Cmt findById(Long id);
    // Update
    public Cmt update(Long id, CmtRequestDto commentRequestDto);
    // Delete
    public void delete(Long id);

}
