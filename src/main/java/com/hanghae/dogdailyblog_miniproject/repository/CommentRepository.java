package com.hanghae.dogdailyblog_miniproject.repository;

import com.hanghae.dogdailyblog_miniproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostIdOrderByModifiedAtDesc(Long postId);
}