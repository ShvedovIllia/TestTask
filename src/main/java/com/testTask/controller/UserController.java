package com.testTask.controller;

import com.testTask.converter.UserConverter;
import com.testTask.entity.UserEntity;
import com.testTask.entity.models.UserRequest;
import com.testTask.entity.models.UserResponse;
import com.testTask.enums.Colors;
import com.testTask.services.UserService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @RequestMapping(value = "/{age}", method = RequestMethod.GET)
    public ResponseEntity<List<UserResponse>> getAllUsersWhenAgeBiggerThan(@PathVariable("age") Integer age) throws NotFoundException {
        List<UserEntity> userEntities = userService.getAllUsersWhereAgeBiggerThenN(age);
        return ResponseEntity.ok(userEntities.stream().map(userConverter::convert).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity saveUser(@RequestBody UserRequest userRequest) {
        userService.saveUser(userConverter.convert(userRequest));
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/byColor/{color}", method = RequestMethod.GET)
    public ResponseEntity<List<UserResponse>> getUsersByArticleColor(@PathVariable("color") Colors colors) {
        List<UserEntity> userEntities = userService.getUsersByArticleEntitiesColor(colors);

        return ResponseEntity.ok(userEntities.stream().map(userConverter::convert).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/articleCount/", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getUsersWhereArticlesGreaterThan() throws NotFoundException {
        return ResponseEntity.ok(userService.getAllUsersWhereArticlesCountGreaterThan());
    }
}
