package com.springboot.menuapp.menuapp.controller;
import com.springboot.menuapp.menuapp.exceptions.AdminNotFoundException;
import com.springboot.menuapp.menuapp.model.Admin;
import com.springboot.menuapp.menuapp.model.ResponseBody;
import com.springboot.menuapp.menuapp.service.AdminService;
import com.springboot.menuapp.menuapp.service.AdminServiceImpl;
import com.springboot.menuapp.menuapp.service.SecurityTokenGenerator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    private AdminService adminService;
    private SecurityTokenGenerator securityTokenGenerator;
    @Autowired
    public AdminController(AdminService adminService, SecurityTokenGenerator securityTokenGenerator) {
        this.adminService = adminService;
        this.securityTokenGenerator = securityTokenGenerator;
    }
    @PostMapping("/signup")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
        Admin createdAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }
    @GetMapping("/checkForAdmin/{email}")
    public ResponseBody checkForAdminExist(@PathVariable String email) {
        return adminService.checkAdmin(email);
    }
    @PostMapping("/login")
    public ResponseEntity<?> adminLogin(@RequestBody Admin admin) throws AdminNotFoundException {
        Map<String, String> map = null;
        try {
            Admin adminUser= adminService.adminLogin(admin.getEmail(), admin.getPassword());
            if (adminUser != null) {
                map = securityTokenGenerator.generateToken(adminUser);
                map.put("user", adminUser.getName());
                map.put("role", adminUser.getRoles());
            }
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        catch (AdminNotFoundException ae) {
            throw new AdminNotFoundException();
        }
        catch (Exception e) {
            return new ResponseEntity<>("other Exception",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAllAdmins")
    public List<Admin> getAllAdmins() {
            return adminService.getAllAdmins();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable String id) {
        Optional<Admin> admin = adminService.getAdminById(id);
        return admin.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable String id, @RequestBody Admin updatedAdmin) {
            Admin admin = adminService.updateAdmin(id, updatedAdmin);
            return admin!=null ? new ResponseEntity<>(admin, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseBody deleteAdmin(@PathVariable String id) {
        return adminService.deleteAdmin(id);
    }
}