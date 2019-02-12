package test.services;

import org.springframework.stereotype.Service;
import test.entity.ArticleEntity;

@Service
public interface ArticleService {

    ArticleEntity saveArticle(ArticleEntity articleEntity);
}
