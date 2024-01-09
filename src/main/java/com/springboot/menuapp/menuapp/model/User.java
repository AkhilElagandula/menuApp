package com.springboot.menuapp.menuapp.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("user")
public class User {
    @Id
    private String id;
    @NotBlank(message = "MobileNumber required")
    @Indexed(unique = true)
    private String mobileNumber;
    private String otp;
    private List<Order> orders;

    public User() {};
    public User(String mobileNumber, String otp, List<Order> orders) {
        this.mobileNumber = mobileNumber;
        this.otp = otp;
        this.orders = orders;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
