package com.hanghae.dogdailyblog_miniproject.repository;

import com.hanghae.dogdailyblog_miniproject.model.Contents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentsRepository extends JpaRepository<Contents, Long> {
    List<Contents> findAllByOrderByCreatedAtDesc();
}
