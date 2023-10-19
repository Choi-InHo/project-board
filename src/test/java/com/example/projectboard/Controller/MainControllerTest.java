package com.example.projectboard.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.example.projectboard.config.SecurityConfig;
import com.example.projectboard.controller.MainController;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Import(SecurityConfig.class)
@WebMvcTest(MainController.class) //공부 해보자
class MainControllerTest {

    private final MockMvc mvc;

    public MainControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }
    @Test
    void givenNothing_whenRequestingRootPage_thenRedirectsToArticlePage() throws Exception {
        //Given

        //When & Then
        mvc.perform(get("/"))
                .andExpect(status().is3xxRedirection());
    }

}