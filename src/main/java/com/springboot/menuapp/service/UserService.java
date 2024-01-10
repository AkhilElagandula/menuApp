package com.springboot.menuapp.service;

import com.springboot.menuapp.exceptions.UserExistException;
import com.springboot.menuapp.model.User;

public interface UserService {
    User createUser(User user) throws UserExistException;
}
