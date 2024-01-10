package com.springboot.menuapp.controller;

import com.springboot.menuapp.model.FoodItem;
import com.springboot.menuapp.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/food-item")
public class FoodItemController {
    private FoodItemService foodItemService;
    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }
    public ResponseEntity<Map<String , Object>> createFoodItem(@RequestBody FoodItem foodItem) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status","success","data",Map.of("food-item",foodItemService.createOne(foodItem))
            ));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status","error",
                    "message",e.getMessage()
            ));
        }
    }
}
