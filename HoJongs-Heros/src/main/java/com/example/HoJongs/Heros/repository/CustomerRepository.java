package com.example.HoJongs.Heros.repository;


import com.example.HoJongs.Heros.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}
