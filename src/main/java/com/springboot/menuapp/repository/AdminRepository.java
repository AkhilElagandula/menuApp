package com.springboot.menuapp.repository;

import com.springboot.menuapp.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
    Optional<Admin> findByName(String name);
    public Admin findByEmail(String email);
    Admin findByEmailAndPassword(String email, String password);
}
