package com.example.HoJongs.Heros.repository;

import com.example.HoJongs.Heros.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}