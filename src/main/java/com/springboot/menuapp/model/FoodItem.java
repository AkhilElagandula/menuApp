package com.springboot.menuapp.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Food Items schema
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("foodItem")
public class FoodItem {
    @Id
    private String id;
    private String name;
    private String image;
    private String description;
    private double price;
    private double prepTime;
    private double calories;
    private String extraDescription;
    private Cuisine cuisineId;
}
