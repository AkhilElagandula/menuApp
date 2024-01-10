package com.springboot.menuapp.service;

import com.springboot.menuapp.exceptions.AdminExistException;
import com.springboot.menuapp.exceptions.AdminNotFoundException;
import com.springboot.menuapp.model.Admin;
import com.springboot.menuapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService{
    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final SecurityTokenGenerator securityTokenGenerator;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository,
                            BCryptPasswordEncoder bCryptPasswordEncoder,
                            SecurityTokenGenerator securityTokenGenerator) {
        this.adminRepository = adminRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.securityTokenGenerator = securityTokenGenerator;
    }
    //Create a document in the collection
    @Override
    public Admin createAdmin(Admin admin) throws AdminExistException {
        Admin createdAdmin = adminRepository.findByEmail(admin.getEmail());
        if (createdAdmin == null) {
            //Generates random userId;
            //admin.setId(UUID.randomUUID().toString().split("-");
            String hashedPassword = hashPassword(admin.getPassword());
            admin.setPassword(hashedPassword);
            admin.setCreatedAt(new Date());
            return adminRepository.save(admin);
        }
        else {
            throw new AdminExistException("200", "Admin with email already exist");
        }
    }
    @Override
    public Map<String, String> adminLogin(Admin admin) throws AdminNotFoundException {
        Map<String, String> map = null;
        Admin adminUser = adminRepository.findByEmail(admin.getEmail());
        if (admin != null) {
            if (bCryptPasswordEncoder.matches(admin.getPassword(),adminUser.getPassword())) {
                map = securityTokenGenerator.generateToken(adminUser);
                map.put("admin", adminUser.getName());
                map.put("role", adminUser.getRoles());
                map.put("id", adminUser.getId());
                return map;
            }
            else {
                return Map.of(
                        "Password mismatch","Please enter correct password",
                        "message","login failure"
                );
            }
        }
        else {
            throw new AdminNotFoundException();
        }
    }
    //Return all the admin data from the collection
    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
    //Return the document of admin based on id
    @Override
    public Admin getAdminById(String email) throws AdminNotFoundException{
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null) {
            return admin;
        }
        else {
            throw new AdminNotFoundException("404", "Admin not found");
        }
    }
    @Override
    public Admin updateAdmin(String id, Admin updatedAdmin) throws AdminNotFoundException {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin != null) {
            admin.setName(updatedAdmin.getName() == null ? updatedAdmin.getName() : admin.getName());
            admin.setEmail(updatedAdmin.getEmail() == null ? updatedAdmin.getEmail() : admin.getEmail());
            admin.setPhone(updatedAdmin.getPhone() == null ? updatedAdmin.getPhone() : admin.getPhone());
            admin.setPhoto(updatedAdmin.getPhoto() == null ? updatedAdmin.getPhoto() : admin.getPhoto());
            admin.setRoles(updatedAdmin.getRoles() == null ? updatedAdmin.getRoles() : admin.getRoles());
            updatedAdmin.setId(id);
            return adminRepository.save(updatedAdmin);
        }
        else {
            throw new AdminNotFoundException("404", "Admin not found");
        }
    }
    //Delete the document from the collection
    @Override
    public boolean deleteAdmin(String id) throws AdminNotFoundException {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin != null) {
            adminRepository.deleteById(id);
            return true;
        }
        else {
            throw new AdminNotFoundException();
        }
    }
    //Method to hash the password
    private String hashPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
