package com.testTask.services.impl;

import com.testTask.entity.UserEntity;

public class UserEntityDummy {

    public static UserEntity createUserEntityDummy(Integer age, String name){
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(age);
        userEntity.setName(name);
        return userEntity;
    }
}
