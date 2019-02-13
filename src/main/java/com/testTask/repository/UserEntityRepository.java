package com.testTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.testTask.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    Optional<List<UserEntity>> findAllByAgeAfter(Integer age);

    UserEntity save(UserEntity userEntity);

    Optional<UserEntity> findById(Long id);
}
