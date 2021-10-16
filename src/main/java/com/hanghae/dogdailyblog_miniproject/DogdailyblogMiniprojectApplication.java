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

}
