package com.hanghae.dogdailyblog_miniproject.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Post {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String title;

    private String content;

    private String writer;

}

