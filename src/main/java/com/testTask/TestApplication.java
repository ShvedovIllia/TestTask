package com.testTask;

import com.testTask.entity.ArticleEntity;
import com.testTask.entity.UserEntity;
import com.testTask.enums.Colors;
import com.testTask.repository.ArticleRepository;
import com.testTask.repository.UserEntityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestApplication.class, args);
        createUsersAndArticles(context);
    }

    private static void createUsersAndArticles(ConfigurableApplicationContext context) {
        ArticleRepository articleRepository = context.getBean(ArticleRepository.class);
        UserEntityRepository userEntityRepository = context.getBean(UserEntityRepository.class);
        if (userEntityRepository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                UserEntity userEntity = new UserEntity();
                userEntity.setName("Name" + i);
                userEntity.setAge(i + 15);
                userEntityRepository.save(userEntity);
            }
        }

        if (articleRepository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                ArticleEntity articleEntity = new ArticleEntity();
                articleEntity.setText("text" + i);
                articleEntity.setColor(Colors.RED);
                articleRepository.save(articleEntity);
            }
        }
    }
}
