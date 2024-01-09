package com.springboot.menuapp.menuapp.repository;

import com.springboot.menuapp.menuapp.model.Cuisine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends MongoRepository<Cuisine, String > {
}
