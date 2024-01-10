package com.springboot.menuapp.service;

import com.springboot.menuapp.model.Admin;

import java.util.Map;

public interface SecurityTokenGenerator {
    public abstract Map<String, String> generateToken(Admin admin);
}
