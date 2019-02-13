package com.testTask.converter;

import com.testTask.entity.ArticleEntity;
import com.testTask.entity.models.ArticleRequest;
import com.testTask.entity.models.ArticleResponse;
import com.testTask.services.UserService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class ArticleConverter {

    private final UserService userService;

    public ArticleEntity convert(ArticleRequest articleRequest) throws NotFoundException {
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setText(articleRequest.getText());
        articleEntity.setColor(articleRequest.getColor());
        articleEntity.setUser(userService.getUserById(articleRequest.getUserId()));
        return articleEntity;
    }

    public ArticleResponse convert(ArticleEntity articleEntity) {
        ArticleResponse articleResponse = new ArticleResponse();
        articleResponse.setText(articleEntity.getText());
        articleResponse.setColors(articleEntity.getColor());
        return articleResponse;

    }
}
