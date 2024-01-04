package com.springboot.menuapp.menuapp.foodItem.model;

import com.springboot.menuapp.menuapp.order.model.Order;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("user")
public class User {

    @Id
    @NotBlank(message = "MobileNumber required")
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
