package com.hanghae.dogdailyblog_miniproject.repository;

import com.hanghae.dogdailyblog_miniproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserid(String username);
}
