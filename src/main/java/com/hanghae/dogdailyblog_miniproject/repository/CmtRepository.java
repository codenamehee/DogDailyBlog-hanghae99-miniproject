package com.hanghae.dogdailyblog_miniproject.repository;

import com.hanghae.dogdailyblog_miniproject.model.Cmt;
import com.hanghae.dogdailyblog_miniproject.model.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CmtRepository extends JpaRepository<Cmt, Long> {
    List<Cmt> findAllByPost(Post findBoard, Sort createdAt);
}