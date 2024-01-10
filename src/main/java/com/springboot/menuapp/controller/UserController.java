package com.springboot.menuapp.controller;

import com.springboot.menuapp.exceptions.UserExistException;
import com.springboot.menuapp.model.User;
import com.springboot.menuapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody User user) throws UserExistException {
        try {
            User userReq = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status","success","data",Map.of("user", userReq)
            ));
        }
        catch (UserExistException ue) {
            throw new UserExistException();
        }
    }
 }
