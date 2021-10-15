package com.hanghae.dogdailyblog_miniproject.security;

import com.hanghae.dogdailyblog_miniproject.model.User;
import com.hanghae.dogdailyblog_miniproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 로그인 요청한 회원의 회원정보 찾는 로직
//    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
//        User user = userRepository.findByUserid(userid).orElseThrow(
//                () -> new UsernameNotFoundException("Can't find " + userid)
//        );
//
//        return new UserDetailsImpl(user);
//    }
    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByUserid(userid)
                .orElseThrow( () -> new UsernameNotFoundException("Can't find" + userid));
    }

}
