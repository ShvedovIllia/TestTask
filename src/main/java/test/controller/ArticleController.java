package test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.converter.ArticleConverter;
import test.entity.models.ArticleRequest;
import test.services.impl.ArticleServiceImpl;

@RestController
@RequestMapping(value = "article/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ArticleController {

    private final ArticleServiceImpl articleService;
    private final ArticleConverter articleConverter;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity addArticle(ArticleRequest articleRequest) {

        articleService.saveArticle(articleConverter.convert(articleRequest));
        return ResponseEntity.ok().build();
    }
}
