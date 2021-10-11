package com.hanghae.dogdailyblog_miniproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String userid;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String pwd;

    public User(String userid, String username, String pwd) {
        this.userid = userid;
        this.username = username;
        this.pwd = pwd;
    }
}