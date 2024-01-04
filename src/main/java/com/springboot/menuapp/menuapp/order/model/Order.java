package com.springboot.menuapp.menuapp.order.model;

import com.springboot.menuapp.menuapp.foodItem.model.FoodItem;
import com.springboot.menuapp.menuapp.foodItem.model.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Order {
    @Id
    private String id;
    @NotBlank(message = "UserId required")
    private User userId; // Assuming 'User' has a String identifier
    private List<FoodItem> items; // Assuming 'FoodItem' has a String identifier

    private OrderStatus status = OrderStatus.ONGOING ;
    @NotBlank(message = "OrderType required")
    private String orderType;
    public Order() {
    }
    public Order(User userId, List<FoodItem> items, OrderStatus status, String orderType) {
        this.userId = userId;
        this.items = items;
        this.status = status;
        this.orderType = orderType;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public void setItems(List<FoodItem> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public enum OrderStatus {
        COMPLETED,
        ONGOING,
        CANCELLED,
        PARTIALLY_COMPLETE
    }
}
