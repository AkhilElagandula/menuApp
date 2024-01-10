package com.springboot.menuapp.service;

import com.springboot.menuapp.model.FoodItem;

import java.util.List;

public interface FoodItemService {
    FoodItem createOne(FoodItem foodItem);
    List<FoodItem> getAll();
    FoodItem updateOne(FoodItem foodItem);
    FoodItem getOne(String id);
    void deleteOne(String id);
}
