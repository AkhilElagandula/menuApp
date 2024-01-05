package com.springboot.menuapp.menuapp.foodItem.service;

import com.springboot.menuapp.menuapp.foodItem.exceptions.AdminExistException;
import com.springboot.menuapp.menuapp.foodItem.exceptions.AdminNotFoundException;
import com.springboot.menuapp.menuapp.foodItem.model.Admin;

public interface AdminService {

    public abstract Admin createAdmin(Admin admin) throws AdminExistException;

    public abstract Admin getAllAdmins();

    public abstract Admin getAdminById(String id) throws AdminNotFoundException;

    public abstract Admin updateAdmin(String id, Admin admin) throws AdminNotFoundException;

    public abstract Admin deleteAdmin(Admin id) throws AdminNotFoundException;
}
