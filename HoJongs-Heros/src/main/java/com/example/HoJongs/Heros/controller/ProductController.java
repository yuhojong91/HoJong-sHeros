package com.example.HoJongs.Heros.controller;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.HoJongs.Heros.model.Product;
import com.example.HoJongs.Heros.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(value = "id") Long Id) {
        Optional<Product> product = productRepository.findById(Id);
        return ResponseEntity.ok().body(product);
    }
}