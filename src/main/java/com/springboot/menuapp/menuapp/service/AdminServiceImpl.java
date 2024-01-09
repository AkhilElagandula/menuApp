package com.springboot.menuapp.menuapp.service;

import com.springboot.menuapp.menuapp.exceptions.AdminNotFoundException;
import com.springboot.menuapp.menuapp.model.Admin;
import com.springboot.menuapp.menuapp.model.ResponseBody;
import com.springboot.menuapp.menuapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    private AdminRepository adminRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private SecurityTokenGenerator securityTokenGenerator;
//    private AdminProxy adminProxy;
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
    public Admin createAdmin(Admin admin){
        //Generates random userId;
        //admin.setId(UUID.randomUUID().toString().split("-
        System.out.println(adminRepository.findByName(admin.getName()));
            if (adminRepository.findByName(admin.getName()).isEmpty()) {
                String hashedPassword = hashPassword(admin.getPassword());
                admin.setPassword(hashedPassword);
                admin.setCreatedAt(new Date());
//                ResponseEntity response = adminProxy.createAdmin(admin);
                return adminRepository.save(admin);
            }
            return null;
    }

    @Override
    public ResponseBody checkAdmin(String email) {
        ResponseBody res = new ResponseBody();
        //System.out.println(adminRepository.findByEmail(email).isEmpty());
        Admin isAdminExist = adminRepository.findByEmail(email);
        if (isAdminExist != null) {
            res.setMessage("Please create a account");
            res.setFlag(true);
        }
        else {
            res.setMessage("Admin Already exist, Please provide another email");
            res.setFlag(false);
        }
        return res;
    }

    @Override
    public Admin adminLogin(String email, String password) throws AdminNotFoundException {
        String pwd = hashPassword(password);
        String adminEmail = email;
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null) {
            return admin;
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
    public Optional<Admin> getAdminById(String id) {
        return adminRepository.findById(id);
    }
//    @Override
//    public Optional<Admin> getAdminByEmail(String email){
//        return adminRepository.findByEmail(email);
//    }

    @Override
    public Admin updateAdmin(String id, Admin updatedAdmin){
        if (adminRepository.existsById(id)) {
//            String hashedPassword = hashPassword(updatedAdmin.getPassword());
//            updatedAdmin.setName(updatedAdmin.getName());
//            updatedAdmin.setPassword(hashedPassword);
            updatedAdmin.setId(id);
            return adminRepository.save(updatedAdmin);
        }
        return null;
    }
    //Delete the document from the collection
    @Override
    public ResponseBody deleteAdmin(String id){
            adminRepository.deleteById(id);
            ResponseBody res = new ResponseBody();
            res.setFlag(true);
            res.setMessage("Admin is deleted");
            res.setCode("200");
            return res;
    }
    //Method to hash the password
    private String hashPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
