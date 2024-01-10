package com.springboot.menuapp.controller;
import com.springboot.menuapp.exceptions.AdminExistException;
import com.springboot.menuapp.exceptions.AdminNotFoundException;
import com.springboot.menuapp.model.Admin;
import com.springboot.menuapp.model.ResponseBody;
import com.springboot.menuapp.service.AdminService;
import com.springboot.menuapp.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    private final AdminService adminService;
    private final SecurityTokenGenerator securityTokenGenerator;
    @Autowired
    public AdminController(AdminService adminService, SecurityTokenGenerator securityTokenGenerator) {
        this.adminService = adminService;
        this.securityTokenGenerator = securityTokenGenerator;
    }
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> createAdmin(@RequestBody Admin admin) throws AdminExistException {
        try {
            Admin createdAdmin = adminService.createAdmin(admin);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status","success",
                    "data",Map.of("Admin", createdAdmin)
            ));
        }
        catch (AdminExistException ae) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status","error",
                    "message",ae.getMessage()
            ));
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> adminLogin(@RequestBody Admin admin) throws AdminNotFoundException {
        try {
            Map<String, String> map = adminService.adminLogin(admin);
            String message = map.get("message") == "login failure" ? map.get("message").split(" ")[1] : "success";
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status",message,
                    "data",Map.of("Admin", map)
            ));
        }
        catch (AdminNotFoundException ae) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status","error",
                    "message",ae.getMessage()
            ));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status","error",
                    "message",e.getMessage()
            ));
        }
    }
    @GetMapping("/getAllAdmins")
    public List<Admin> getAllAdmins() {
            return adminService.getAllAdmins();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getAdminById(@PathVariable String id) throws AdminNotFoundException{
        try {
            Admin admin = adminService.getAdminById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                    "status","success",
                    "data",Map.of("Admin",admin)
            ));
        }
        catch (AdminNotFoundException ane) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                    "status","error",
                    "message",ane.getMessage()
            ));
        }
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateAdmin(@PathVariable String id, @RequestBody Admin updatedAdmin) throws AdminNotFoundException {
        try {
            Admin admin = adminService.updateAdmin(id, updatedAdmin);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                    "status","success",
                    "data",Map.of("Admin",admin)
            ));
        }
        catch (AdminNotFoundException ane) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                    "status","error",
                    "message",ane.getMessage()
            ));
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteAdmin(@PathVariable String id) throws AdminNotFoundException {
        try {
            Admin admin = adminService.getAdminById(id);
            boolean isDeleted = adminService.deleteAdmin(id);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                    "status","success",
                    "data",Map.of(
                            "isAdminDeleted",isDeleted,
                            "Email",admin.getEmail())
            ));
        }
        catch (AdminNotFoundException ane) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                    "status","error",
                    "message",ane.getMessage()
            ));
        }
    }
}