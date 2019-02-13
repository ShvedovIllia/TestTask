package com.testTask.converter;

import com.testTask.entity.UserEntity;
import com.testTask.entity.models.UserRequest;
import com.testTask.entity.models.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convert (UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(userRequest.getAge());
        userEntity.setName(userRequest.getName());
        return userEntity;
    }

    public UserResponse convert (UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setAge(userEntity.getAge());
        userResponse.setName(userEntity.getName());
        userResponse.setArticles(userEntity.getArticleEntities());
        return userResponse;
    }
}
