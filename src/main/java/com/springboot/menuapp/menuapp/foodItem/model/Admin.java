package com.springboot.menuapp.menuapp.foodItem.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("admin")
public class Admin {
    @Id
    @NotBlank(message = "UserName required")
    private String userName;
    @NotBlank(message = "Password required")
    private String password;

    public Admin() {};

    public Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
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
}
