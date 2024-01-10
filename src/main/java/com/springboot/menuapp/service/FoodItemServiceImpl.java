package com.springboot.menuapp.service;

import com.springboot.menuapp.model.FoodItem;
import com.springboot.menuapp.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemServiceImpl implements FoodItemService{
    private FoodItemRepository foodItemRepository;
    public FoodItemServiceImpl(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    @Override
    public FoodItem createOne(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    @Override
    public List<FoodItem> getAll() {
        return foodItemRepository.findAll();
    }

    @Override
    public FoodItem updateOne(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    @Override
    public FoodItem getOne(String id) {
        return foodItemRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOne(String id) {
        foodItemRepository.deleteById(id);
    }
}
