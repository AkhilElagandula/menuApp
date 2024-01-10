package com.springboot.menuapp.service;

import com.springboot.menuapp.model.Cart;
import com.springboot.menuapp.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    private CartRepository cartRepository;
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    @Override
    public Cart createCart(Cart cart) {
        return null;
    }
}
