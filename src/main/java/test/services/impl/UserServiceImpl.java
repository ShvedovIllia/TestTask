package test.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.entity.UserEntity;
import test.repository.UserEntityRepository;
import test.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserServiceImpl implements UserService {

    private final UserEntityRepository userRepository;

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsersWhereAgeBiggerThenN(Integer age) {
        return userRepository.findAllByAgeAfter(age).orElse(new ArrayList<>());
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(new UserEntity());
    }
}
