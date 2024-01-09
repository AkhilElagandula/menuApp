package com.springboot.menuapp.menuapp.model;

import com.springboot.menuapp.menuapp.model.FoodItem;
import com.springboot.menuapp.menuapp.model.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("cart")
public class Cart {
    @Id
    private String id;

    private User userId;
    private List<FoodItem> items;

    public Cart() {
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

    public Cart(User userId, List<FoodItem> items) {
        this.userId = userId;
        this.items = items;
    }


}
