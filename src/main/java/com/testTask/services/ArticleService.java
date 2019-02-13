package com.testTask.services;

import com.testTask.entity.ArticleEntity;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {

    ArticleEntity saveArticle(ArticleEntity articleEntity);
}
