package com.example.projectboard.config;

import com.example.projectboard.dto.UserAccountDto;
import com.example.projectboard.dto.security.BoardPrincipal;
import com.example.projectboard.repository.UserAccountRepository;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .mvcMatchers(
                                //여기를 제외하고는 전부 다 인증을 해야 함
                                HttpMethod.GET,
                                "/","/articles","/articles/search-hashtag"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin().and()
                .logout()
                        .logoutSuccessUrl("/")
                        .and()
                .build();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCusomizer(){
        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public UserDetailsService userDetailsService(UserAccountRepository userAccountRepository){
        return username -> userAccountRepository
                .findById(username)
                .map(UserAccountDto::from)
                .map(BoardPrincipal::from)
                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다."));
    }

    //반드시 넣어줘야 함
    //이걸 넣어줬을때는 앞에 {noop}을 넣어줘야 함
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}