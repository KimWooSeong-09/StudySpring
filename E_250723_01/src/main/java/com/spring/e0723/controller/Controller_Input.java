package com.spring.e0723.controller;

import org.springframework.ui.Model;
import com.spring.e0723.dto.ArticleForm;
import com.spring.e0723.entity.Article;
import com.spring.e0723.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 1*/
@Controller
@Slf4j
public class Controller_Input {
    //1. 변수 선언 DI
//    @Autowired
//    private ArticleRepository articleRepository;

    //3. 생성자 DI
    private final ArticleRepository articleRepository;
    Controller_Input(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/input")
    public String input(Model model) {
        // 작성 코드
        return "Input";
    }

    @PostMapping("/create")
    public String createArticle(ArticleForm form) {
        log.info("사용자 정보 출력" + form);
        //1. 사용자 정보가 저장된 DTO를 ENTITY로 변경.
        Article entity = form.toEntity();
        System.out.println(entity);
        log.info("entity" + entity);

        //2. DB에 추가하기
        Article save = articleRepository.save(entity);
        System.out.println(entity);
        return "show";
    }

    /** localhost:8080//3 show
     insert into article values(1, '112', '가나다라')
     insert into article values(2, '113', '가나다라')
     insert into article values(3, '114', '가나다라')
    /** localhost:8080/show/3*/
    @GetMapping("/show/{id}")
    public String show(
            @PathVariable Long id,
            Model model
    ) {
        log.info("show() / id : " + id);

        Article article = articleRepository.findById(id).orElse(null);
        log.info("show() / article : " + article);

        model.addAttribute("article", article);
        return "show";
    }

    @GetMapping("/articles")
    public String index() {
        /** 1. DB에서  모든 데이터 가져 오기*/
        articleRepository.findAll();

        /** 2. 가지고온 데이터를 뷰화면에 전달 --> Model*/
        return "";
    }
}
