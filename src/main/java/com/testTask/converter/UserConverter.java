package com.testTask.converter;

import com.testTask.entity.UserEntity;
import com.testTask.entity.models.UserRequest;
import com.testTask.entity.models.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserConverter {

    private final ArticleConverter articleConverter;

    public UserEntity convert(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(userRequest.getAge());
        userEntity.setName(userRequest.getName());
        return userEntity;
    }

    public UserResponse convert(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setAge(userEntity.getAge());
        userResponse.setName(userEntity.getName());
        userResponse.setArticles(userEntity.getArticleEntities().stream().map(articleConverter::convert).collect(Collectors.toList()));
        return userResponse;
    }
}
