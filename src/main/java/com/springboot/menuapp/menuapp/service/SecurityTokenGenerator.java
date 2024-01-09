package com.springboot.menuapp.menuapp.service;

import com.springboot.menuapp.menuapp.model.Admin;

import java.util.Map;
import java.util.Optional;

public interface SecurityTokenGenerator {
    public abstract Map<String, String> generateToken(Admin admin);
}
