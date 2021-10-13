package com.hanghae.dogdailyblog_miniproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    // Cors 허용 적용
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // 허용할 URL
        configuration.addAllowedOrigin("http://localhost:3000");
        // 허용할 Header
        configuration.addAllowedHeader("*");
        // 허용할 Http Method
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // cors 설정
        http.cors();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()

                .antMatchers("/index/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/**").permitAll()
                .antMatchers("*").permitAll()

                .anyRequest().authenticated()
                .and()
                // 로그인 기능
                .formLogin()
//                // 로그인 view 제공 (GET/user/login)
//                .loginPage("/user/login")
                // 로그인 처리 (POST/user/login)
                .loginProcessingUrl("/user/login")
//                // 로그인 처리 후 성공 시 URL
                .defaultSuccessUrl("/user/login")
//                // 로그인 처리 후 실패 시 URL
//                .failureUrl("user/login?error")
                .permitAll()
                .and()
                .logout()
                // 로그아웃 처리
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/")
                .permitAll();
//                .and()
//                .exceptionHandling()
                //접근 불가 페이지 URL 설정
//                .accessDeniedPage("/");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
