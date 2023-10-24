package com.example.projectboard.config;

import com.example.projectboard.domain.UserAccount;
import com.example.projectboard.repository.UserAccountRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {

    @MockBean private UserAccountRepository userAccountRepository;

    @BeforeTestMethod //각 테스트 메소드가 실행되기 직전에 아래 코드를 실행해서 인증 정보를 넣어줘라
    public void securitySetUp() {
        given(userAccountRepository.findById(anyString())).willReturn(Optional.of(UserAccount.of("unoTest","pw","uno-test@mail.com","uno-test","test-memo")));
    }
}
