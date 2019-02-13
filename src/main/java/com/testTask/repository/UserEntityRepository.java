package com.testTask.repository;

import com.testTask.enums.Colors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    List<UserEntity> findByArticleEntities_Color(Colors colors);

    @Query(value = "select distinct name from user_entity as u left join article as a on u.id " +
            "= a.user_id where (select count(*) from article as ar where ar.user_id = a.user_id) > 3", nativeQuery = true)
    List<String> findAllByCountMoreThan3();
}
