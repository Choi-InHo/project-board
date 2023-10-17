package com.example.projectboard.Controller;

import com.example.projectboard.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("View 컨트롤러 인증부분")
@Import(SecurityConfig.class)
@WebMvcTest
public class AuthControllerTest {

        private final MockMvc mvc;

        public AuthControllerTest(@Autowired MockMvc mvc) {
            this.mvc = mvc;
        }

        @DisplayName("[view][get] 로그인 페이지 - 정상 호출")
        @Test
        public void given_when_then() throws Exception {

            mvc.perform(get("/login")) // perform -> 요청을 전송함
                    .andExpect(status().isOk())
                    .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));


        }


    }

