package com.springboot.menuapp.menuapp.foodItem.controller;

import com.springboot.menuapp.menuapp.foodItem.exceptions.AdminExistException;
import com.springboot.menuapp.menuapp.foodItem.exceptions.AdminNotFoundException;
import com.springboot.menuapp.menuapp.foodItem.model.Admin;
import com.springboot.menuapp.menuapp.foodItem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAdmin(@RequestBody Admin admin) throws AdminExistException {
        try {
            if (admin.getRole() == null) {
                admin.setRole(Admin.AdminRole.SUB);
            }
            return new ResponseEntity<>(adminService.createAdmin(admin), HttpStatus.CREATED);
        }
        catch (AdminExistException ae) {
            throw new AdminExistException();
        }
    }

    @GetMapping("/admins")
    public ResponseEntity<?> getAllAdmins() {
        try {
            return new ResponseEntity<>(adminService.getAllAdmins(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Exception occured.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')") //Only Super Admin can update admin details
    public ResponseEntity<Admin> updateAdmin(@PathVariable String id, @RequestBody Admin admin) {
        try {
            Admin updatedAdmin = adminService.updateAdmin(id, admin);
            return ResponseEntity.ok(updatedAdmin);
         }
        catch (AdminNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
