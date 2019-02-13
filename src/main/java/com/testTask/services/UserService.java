package com.testTask.services;

import com.testTask.entity.UserEntity;
import com.testTask.enums.Colors;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface UserService {

    UserEntity saveUser(UserEntity userEntity);

    List<UserEntity> getAllUsersWhereAgeBiggerThenN(Integer n) throws NotFoundException;

    UserEntity getUserById(Long id) throws NotFoundException;

    List<UserEntity> getUsersByArticleEntitiesColor(Colors colors);

    List<String> getAllUsersWhereArticlesCountGreaterThan() throws NotFoundException;
}
