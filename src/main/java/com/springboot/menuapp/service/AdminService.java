package com.springboot.menuapp.service;

import com.springboot.menuapp.exceptions.AdminExistException;
import com.springboot.menuapp.exceptions.AdminNotFoundException;
import com.springboot.menuapp.model.Admin;
import com.springboot.menuapp.model.ResponseBody;
import java.util.List;
import java.util.Map;

public interface AdminService {
    Admin createAdmin(Admin admin) throws AdminExistException;
    Map<String , String> adminLogin(Admin admin) throws AdminNotFoundException;
    List<Admin> getAllAdmins();
    Admin getAdminById(String email) throws AdminNotFoundException;
    Admin updateAdmin(String id, Admin updatedAdmin) throws AdminNotFoundException;
    boolean deleteAdmin(String id) throws AdminNotFoundException;
}
