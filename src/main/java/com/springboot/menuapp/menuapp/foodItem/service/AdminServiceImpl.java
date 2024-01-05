package com.springboot.menuapp.menuapp.foodItem.service;

import com.springboot.menuapp.menuapp.foodItem.exceptions.AdminExistException;
import com.springboot.menuapp.menuapp.foodItem.exceptions.AdminNotFoundException;
import com.springboot.menuapp.menuapp.foodItem.model.Admin;
import com.springboot.menuapp.menuapp.foodItem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, BCryptPasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Admin createAdmin(Admin admin) throws AdminExistException {
        if (adminRepository.findById(admin.getUserName()).isEmpty()) {
            String hashedPassword = hashPassword(admin.getPassword());
            admin.setPassword(hashedPassword);
            //create a document
            return adminRepository.save(admin);
        } else {
            throw new AdminExistException();
        }
    }

    @Override
    public Admin getAllAdmins() {
        return null;
    }

    @Override
    public Admin getAdminById(String id) throws AdminNotFoundException {
        return adminRepository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException());
    }

    @Override
    public Admin updateAdmin(String id, Admin admin) throws AdminNotFoundException {
        Admin existingAdmin = getAdminById(id);
        if (existingAdmin != null) {
            String hashedPassword = hashPassword(admin.getPassword());
            admin.setUserName(admin.getUserName());
            admin.setPassword(hashedPassword);
            return adminRepository.save(admin);
        }
        return admin;
    }

    @Override
    public Admin deleteAdmin(Admin id) throws AdminNotFoundException {
        return null;
    }

    //Method to hash the password
    private String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
