package com.springboot.menuapp.menuapp.repository;

import com.springboot.menuapp.menuapp.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
    Optional<Admin> findByName(String name);
    public abstract Admin findByEmail(String email);
    Admin findByEmailAndPassword(String email, String password);
}
