package com.testTask.services;

import com.testTask.entity.UserEntity;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserEntity saveUser(UserEntity userEntity);

    List<UserEntity> getAllUsersWhereAgeBiggerThenN(Integer n) throws NotFoundException;

    UserEntity getUserById(Long id) throws NotFoundException;

}
