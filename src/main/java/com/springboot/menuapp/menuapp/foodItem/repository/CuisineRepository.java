package com.springboot.menuapp.menuapp.foodItem.repository;

import com.springboot.menuapp.menuapp.foodItem.model.Cuisine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends MongoRepository<Cuisine, String > {
}
