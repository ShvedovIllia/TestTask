package com.testTask.services.impl;

import com.testTask.entity.UserEntity;
import com.testTask.repository.UserEntityRepository;
import javassist.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;
    @MockBean
    private UserEntityRepository userEntityRepository;

    @Before
    public void setUp() throws Exception {
        UserEntity userEntity = UserEntityDummy.createUserEntityDummy(21, "Illia");
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(userEntity);
        Mockito.when(userEntityRepository.findById(1L)).thenReturn(Optional.of(userEntity));
        Mockito.when(userEntityRepository.findAllByAgeAfter(15)).thenReturn(Optional.of(userEntities));
    }

    @Test
    public void getUserByIdTest() throws NotFoundException {
        Integer age = 21;
        UserEntity userEntityActual = userService.getUserById(1L);
        Assert.assertEquals(age, userEntityActual.getAge());
    }

    @Test
    public void getAllUsersWhereAgeBiggerThenNTest() throws NotFoundException {
        List<UserEntity> userEntities = userService.getAllUsersWhereAgeBiggerThenN(15);
        Assert.assertEquals(1, userEntities.size());
    }


}
