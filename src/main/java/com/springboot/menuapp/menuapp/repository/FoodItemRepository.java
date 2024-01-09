package com.springboot.menuapp.menuapp.repository;

import com.springboot.menuapp.menuapp.model.FoodItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodItemRepository extends MongoRepository<FoodItem, String> {
}
