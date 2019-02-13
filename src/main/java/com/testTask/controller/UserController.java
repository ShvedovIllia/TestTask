package com.testTask.controller;

import com.testTask.entity.models.UserRequest;
import com.testTask.entity.models.UserResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.testTask.converter.UserConverter;
import com.testTask.entity.UserEntity;
import com.testTask.services.UserService;

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
    public void saveUser(@RequestBody UserRequest userRequest) {
        userService.saveUser(userConverter.convert(userRequest));
    }
}