package com.hanghae.dogdailyblog_miniproject;

import com.hanghae.dogdailyblog_miniproject.model.Contents;
import com.hanghae.dogdailyblog_miniproject.repository.ContentsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
public class DogdailyblogMiniprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogdailyblogMiniprojectApplication.class, args);}

    @PostConstruct
    public void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }
    //더미데이터
    @Bean
    public CommandLineRunner demo(ContentsRepository repository) {
        return (args) -> {
            repository.save(new Contents("제목","닉네임","id", "내용", "주소"));
        };
    }
}
