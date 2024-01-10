package com.springboot.menuapp.service;

import com.springboot.menuapp.model.Admin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(Admin admin) {
        Date currentDate = new Date();
        currentDate.setMinutes(currentDate.getMinutes() + 1);

        String jwtToken = Jwts.builder()
                .setSubject(admin.getName())
                .setIssuedAt(new Date())
                .setExpiration(currentDate)
                .signWith(SignatureAlgorithm.HS256,"appKey").compact();

        Map<String, String> map = new HashMap<>();
        map.put("token", jwtToken);
        map.put("message", "Logged in Success");
        return map;
    }
}
