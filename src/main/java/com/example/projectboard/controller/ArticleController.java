package com.example.projectboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @GetMapping
    public String articles(ModelMap map){
        map.addAttribute("articles", List.of());
        return "articles/index";
    }

    @GetMapping("/{articleId}") // 단건 조
    public String article(@PathVariable long articleId, ModelMap map){
        map.addAttribute("article", "article"); //TODO:실제 데이터를 넣어주어야 함
        map.addAttribute("articleComments", List.of());

        return "articles/detail";
    }
}
