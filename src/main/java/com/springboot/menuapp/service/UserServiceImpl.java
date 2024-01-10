package com.springboot.menuapp.service;

import com.springboot.menuapp.exceptions.UserExistException;
import com.springboot.menuapp.model.User;
import com.springboot.menuapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User createUser(User user) throws UserExistException {
        User u = new User();
        u.setName(user.getName());
        u.setMobileNumber(user.getMobileNumber());
        return userRepository.save(u);
    }
}
