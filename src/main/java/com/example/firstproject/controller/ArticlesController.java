package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j //로깅을 위한 어노테이션
public class ArticlesController {

    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동으로 연결 = new ArticleRepositoryimpl 을 안써도 됨
    private ArticleRepository articleRepository;

    @GetMapping("articles/new")
    public String newArticlesForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        //System.out.println(form.toString());
        log.info(form.toString());

        // 1. Dto를 변환 -> Entity
        Article article = form.toEntitiy();
        //System.out.println(article.toString());
        log.info(article.toString());

        // 2. Reposotory에게 Entity를 DB안에 저장하게 함
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(saved.toString());
        return "";
    }

    @GetMapping("hello-mvc")
    public String helloSpring(@RequestParam("name") String name, Model model)
    {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
