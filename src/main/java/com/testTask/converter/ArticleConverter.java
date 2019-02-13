package com.testTask.converter;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.testTask.entity.ArticleEntity;
import com.testTask.entity.models.ArticleRequest;
import com.testTask.services.UserService;

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
}
