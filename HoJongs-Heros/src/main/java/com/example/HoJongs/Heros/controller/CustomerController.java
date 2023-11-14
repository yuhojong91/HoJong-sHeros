package com.example.HoJongs.Heros.controller;

import com.example.HoJongs.Heros.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @GetMapping("/message")
    public ResponseEntity<Customer> getMessage(){
        Customer customerOne = new Customer("1234567890", "HJ", "125 Bergen", "Berkerly", "NJ", 07650);
        return ResponseEntity.ok().body(customerOne);
    }
}
