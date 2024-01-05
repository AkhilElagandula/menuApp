package com.springboot.menuapp.menuapp.foodItem.repository;

import com.springboot.menuapp.menuapp.foodItem.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
    Admin findByUserName(String userName);
}
