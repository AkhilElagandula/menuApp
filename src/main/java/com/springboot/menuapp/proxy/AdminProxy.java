package com.springboot.menuapp.proxy;

import com.springboot.menuapp.model.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AdminProxy {
    @PostMapping("api/v1/admin/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin);
}
