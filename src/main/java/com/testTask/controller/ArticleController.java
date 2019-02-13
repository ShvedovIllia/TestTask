package com.testTask.controller;

import com.testTask.converter.ArticleConverter;
import com.testTask.entity.models.ArticleRequest;
import com.testTask.services.impl.ArticleServiceImpl;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "article/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ArticleController {

    private final ArticleServiceImpl articleService;
    private final ArticleConverter articleConverter;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity addArticle(@RequestBody final ArticleRequest articleRequest) throws NotFoundException {
        log.info("add new article with color:" + articleRequest.getColor());
        articleService.saveArticle(articleConverter.convert(articleRequest));
        return ResponseEntity.ok().build();
    }
}
