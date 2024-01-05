package com.springboot.menuapp.menuapp.foodItem.repository;

import com.springboot.menuapp.menuapp.foodItem.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
