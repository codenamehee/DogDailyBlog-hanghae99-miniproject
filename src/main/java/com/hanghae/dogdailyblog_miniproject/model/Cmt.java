package com.hanghae.dogdailyblog_miniproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hanghae.dogdailyblog_miniproject.dto.CmtRequestDto;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import static javax.persistence.FetchType.LAZY; //연관 관계에 있는 Entity 가져오지 않고, getter 로 접근할 때 가져온다 → Lazy 전략


public class Cmt extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String comment;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Contents contents;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    public Cmt(String comment, Contents contents, User user) {
        this.comment = comment;
        this.contents = contents;
        this.user = user;
    }

    public Cmt update(CmtRequestDto commentRequestDto) {
        this.comment = commentRequestDto.getComment();
        return this;
    }
}




