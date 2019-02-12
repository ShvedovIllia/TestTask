package test.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.entity.ArticleEntity;
import test.entity.models.ArticleRequest;
import test.services.UserService;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class ArticleConverter {

    private final UserService userService;

    public ArticleEntity convert(ArticleRequest articleRequest) {
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setText(articleRequest.getText());
        articleEntity.setColor(articleRequest.getColor());
        return articleEntity;
    }
}
