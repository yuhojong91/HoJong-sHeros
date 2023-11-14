package com.example.HoJongs.Heros.controller;

import com.example.HoJongs.Heros.model.Customer;
import com.example.HoJongs.Heros.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")


public class CustomerController {
    @GetMapping("/message")
    public ResponseEntity<Customer> getMessage(){
        Customer customerOne = new Customer("1234567890", "HJ", "125 Bergen", "Berkerly", "NJ", 07650);
        return ResponseEntity.ok().body(customerOne);
    }

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customer")
        public ResponseEntity<Customer> getCarForId(@RequestBody Customer customer) {
        
        var newCustomer = customerRepository.save(customer);
        return ResponseEntity.ok().body(newCustomer);
    }
}
