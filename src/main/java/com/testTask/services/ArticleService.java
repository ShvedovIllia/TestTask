package com.testTask.services;

import org.springframework.stereotype.Service;
import com.testTask.entity.ArticleEntity;

@Service
public interface ArticleService {

    ArticleEntity saveArticle(ArticleEntity articleEntity);
}
