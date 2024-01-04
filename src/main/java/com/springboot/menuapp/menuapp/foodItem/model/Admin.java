package com.springboot.menuapp.menuapp.foodItem.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("admin")
public class Admin {
    @Id
    private String id;
    @NotBlank(message = "UserName required")
    @Indexed(unique = true)
    private String userName;
    @NotBlank(message = "Password required")
    private String password;

    private AdminRole role = AdminRole.SUB;

    public Admin() {};

    public Admin(String userName, String password, AdminRole role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public AdminRole getRole() {
        return role;
    }

    public void setRole(AdminRole role) {
        this.role = role;
    }

    public enum AdminRole {
        SUPER,
        SUB
    }
}
