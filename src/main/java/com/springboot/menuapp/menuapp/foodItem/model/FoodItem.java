package com.springboot.menuapp.menuapp.foodItem.model;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Food Items schema
@Document("foodItem")
public class FoodItem {
    @Id
    private String id;
    @NotBlank(message = "Name required")
    private String name;
    private String image;
    private String description;
    @NotBlank(message = "Name required")
    private double price;
    private double prepTime;
    private double calories;
    private String extraDescription;
    private Cuisine cuisineId;

    public FoodItem() {};

    public FoodItem(String name, String image, String description, double price, double prepTime, double calories, String extraDescription, Cuisine cuisineId) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.prepTime = prepTime;
        this.calories = calories;
        this.extraDescription = extraDescription;
        this.cuisineId = cuisineId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(double prepTime) {
        this.prepTime = prepTime;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public String getExtraDescription() {
        return extraDescription;
    }

    public void setExtraDescription(String extraDescription) {
        this.extraDescription = extraDescription;
    }

    public Cuisine getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(Cuisine cuisineId) {
        this.cuisineId = cuisineId;
    }
}
