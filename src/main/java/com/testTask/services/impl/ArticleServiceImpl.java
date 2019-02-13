package com.testTask.services.impl;

import com.testTask.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.testTask.entity.ArticleEntity;
import com.testTask.repository.ArticleRepository;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public ArticleEntity saveArticle(ArticleEntity articleEntity) {
        return articleRepository.save(articleEntity);
    }
}
