package com.springboot.menuapp.menuapp.foodItem.repository;

import com.springboot.menuapp.menuapp.foodItem.model.FoodItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodItemRepository extends MongoRepository<FoodItem, String> {
}
