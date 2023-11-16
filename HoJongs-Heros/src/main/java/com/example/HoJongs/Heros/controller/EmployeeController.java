package com.example.HoJongs.Heros.controller;

import com.example.HoJongs.Heros.model.Customer;
import com.example.HoJongs.Heros.model.CustomerOrder;
import com.example.HoJongs.Heros.model.Employee;
import com.example.HoJongs.Heros.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")


public class EmployeeController {
    // @GetMapping("/message")
    // public ResponseEntity<Employee> getMessage(){
    //     Customer customerOne = new Customer("1234567890", "HJ", "125 Bergen", "Berkerly", "NJ", "07650");
    //     return ResponseEntity.ok().body(customerOne);
    // }

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * @param employee
     * @return
     */
    @PostMapping("/employee")
    public ResponseEntity<Employee> getEmployee(@RequestBody Employee employee) {
        var newEmployee= employeeRepository.save(employee);
        return ResponseEntity.ok().body(newEmployee);
 
    }
}

