package test.services;

import org.springframework.stereotype.Service;
import test.entity.UserEntity;

import java.util.List;

@Service
public interface UserService {

    UserEntity saveUser(UserEntity userEntity);

    List<UserEntity> getAllUsersWhereAgeBiggerThenN(Integer n);

    UserEntity getUserById(Long id);

}
