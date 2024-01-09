package com.springboot.menuapp.menuapp.service;

import com.springboot.menuapp.menuapp.exceptions.AdminNotFoundException;
import com.springboot.menuapp.menuapp.model.Admin;
import com.springboot.menuapp.menuapp.model.ResponseBody;
import com.springboot.menuapp.menuapp.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AdminService {

    public abstract Admin createAdmin(Admin admin);

    public abstract ResponseBody checkAdmin(String email);

    public abstract Admin adminLogin(String email, String password) throws AdminNotFoundException;
    public abstract List<Admin> getAllAdmins();

    public abstract Optional<Admin> getAdminById(String username);

    //public abstract Optional<Admin> getAdminByEmail(String email);

    public abstract Admin updateAdmin(String id, Admin updatedAdmin);

    public abstract ResponseBody deleteAdmin(String id);
}
