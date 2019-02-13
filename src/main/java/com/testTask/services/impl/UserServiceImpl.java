package com.testTask.services.impl;

import com.testTask.entity.UserEntity;
import com.testTask.enums.Colors;
import com.testTask.repository.UserEntityRepository;
import com.testTask.services.UserService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserServiceImpl implements UserService {

    private final UserEntityRepository userRepository;

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsersWhereAgeBiggerThenN(Integer age) throws NotFoundException {
        return userRepository.findAllByAgeAfter(age).orElseThrow(() -> new NotFoundException("not found"));
    }

    @Override
    public UserEntity getUserById(Long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("not found"));
    }

    @Override
    public List<UserEntity> getUsersByArticleEntitiesColor(Colors colors) {
        return userRepository.findByArticleEntities_Color(colors);
    }

    @Override
    public List<String> getAllUsersWhereArticlesCountGreaterThan() throws NotFoundException {
        return userRepository.findAllByCountMoreThan3();
    }
}
