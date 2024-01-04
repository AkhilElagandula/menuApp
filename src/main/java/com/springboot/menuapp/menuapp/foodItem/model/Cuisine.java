package com.springboot.menuapp.menuapp.foodItem.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//Cuisine schema
@Document("cuisine")
public class Cuisine {
    @Id
    @NotBlank(message = "Name required")
    private String name;
    private String image;
    private List<FoodItem> foodItems;

    public Cuisine() {};

    public Cuisine(String name, String image, List<FoodItem> foodItems) {
        this.name = name;
        this.image = image;
        this.foodItems = foodItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
