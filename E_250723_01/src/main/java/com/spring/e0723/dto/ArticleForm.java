package com.spring.e0723.dto;

import com.spring.e0723.entity.Article;

public class ArticleForm {
    private String title;
    private String content;

    // 기본 생성자 (필수)
    public ArticleForm() {}

    // 생성자
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    /** DTO를 ENTITY로 변경하는 메소드*/
    public Article toEntity() {
        return new Article(null, title, content);
    }

    @Override
    public String toString() {
        return "ArticleForm{title='" + title + "', content='" + content + "'}";
    }
}