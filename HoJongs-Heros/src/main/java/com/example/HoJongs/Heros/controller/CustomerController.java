package com.example.HoJongs.Heros.controller;

import com.example.HoJongs.Heros.model.Customer;
import com.example.HoJongs.Heros.repository.CustomerRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")


public class CustomerController {
    @GetMapping("/message")
    public ResponseEntity<Customer> getMessage(){
        Customer customerOne = new Customer("1234567890", "HJ", "125 Bergen", "Berkerly", "NJ", "07650");
        return ResponseEntity.ok().body(customerOne);
    }

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add_customer")
    public ResponseEntity<?> getCarForId(@RequestBody Customer customer) {
        // optional is used to represent a value that is either there or not there, essentially wrapping around another object.
        Optional<Customer> existingCustomer = customerRepository.findByPhoneNumber(customer.getPhoneNumber());
        if (existingCustomer.isPresent()){ // isPresent is part of Optional method that returns true if it's value contains a non-null value
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A customer with phone number " + customer.getPhoneNumber() + " already exist. Please register this customer");
        }
        var newCustomer = customerRepository.save(customer);
        return ResponseEntity.ok().body(newCustomer);
    }

    @GetMapping("/get_customer/{phoneNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable String phoneNumber){
        try{
            Customer customer = customerRepository.findByPhoneNumber(phoneNumber)
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found with phone number: " + phoneNumber));
            return ResponseEntity.ok().body(customer);
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/update_customer/{Id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Integer Id, @RequestBody Customer customerData) {
        return customerRepository.findById(Id).map(existingCustomer -> {
            if (customerData.getName() != null) existingCustomer.setName(customerData.getName());
            if (customerData.getPhoneNumber() != null) existingCustomer.setPhoneNumber(customerData.getPhoneNumber());
            if (customerData.getAddress() != null) existingCustomer.setAddress(customerData.getAddress());
            if (customerData.getCity() != null) existingCustomer.setCity(customerData.getCity());
            if (customerData.getState() != null) existingCustomer.setState(customerData.getState());
            if (customerData.getZipCode() != null) existingCustomer.setZipCode(customerData.getZipCode());

            Customer updatedCustomer = customerRepository.save(existingCustomer);
            return ResponseEntity.ok().body(updatedCustomer);
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
