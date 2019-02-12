package test.converter;

import org.springframework.stereotype.Component;
import test.entity.UserEntity;
import test.entity.models.UserRequest;
import test.entity.models.UserResponse;

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
        return userResponse;
    }
}
