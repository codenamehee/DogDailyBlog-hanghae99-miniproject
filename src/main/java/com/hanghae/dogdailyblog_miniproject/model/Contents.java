package com.hanghae.dogdailyblog_miniproject.model;

import com.hanghae.dogdailyblog_miniproject.dto.ContentsRequestDto;
import com.hanghae.dogdailyblog_miniproject.repository.ContentsRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Contents extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String imageurl;

    public Contents(String title, String username, String contents, String imageurl){
        this.title = title;
        this.username = username;
        this.contents = contents;
        this.imageurl = imageurl;
    }
    public Contents(ContentsRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.imageurl = requestDto.getImageurl();
    }
    public Contents(ContentsRequestDto requestDto, String username){
        this.title = requestDto.getTitle();
        this.username = username;
        this.contents = requestDto.getContents();
        this.imageurl = requestDto.getImageurl();
    }

    public void update(ContentsRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.imageurl = requestDto.getImageurl();
    }
    public Contents(ContentsRequestDto requestDto, String username, String contents){
        this.title = requestDto.getTitle();
        this.username = username;
        this.contents = contents;
        this.imageurl = requestDto.getImageurl();
    }

}