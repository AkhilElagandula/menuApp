package com.springboot.menuapp.menuapp.repository;

import com.springboot.menuapp.menuapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
