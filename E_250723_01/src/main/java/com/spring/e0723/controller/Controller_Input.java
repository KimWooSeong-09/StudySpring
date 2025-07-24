package com.spring.e0723.controller;

import ch.qos.logback.core.model.Model;
import com.spring.e0723.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controller_Input {
    @GetMapping("/input")
    public String input(Model model) {
        // 작성 코드
        return "Input";
    }

    @PostMapping("/create")
    public String createArticle(ArticleForm form) {
        System.out.println("사용자 정보 출력" + form);
        return "";
    }
}
