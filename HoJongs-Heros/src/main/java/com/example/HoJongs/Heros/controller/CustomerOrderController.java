package com.example.HoJongs.Heros.controller;

import java.util.Optional;
import com.example.HoJongs.Heros.model.Customer;
import com.example.HoJongs.Heros.model.CustomerOrder;
import com.example.HoJongs.Heros.model.Employee;
import com.example.HoJongs.Heros.repository.EmployeeRepository;
import com.example.HoJongs.Heros.repository.CustomerOrderRepository;
import com.example.HoJongs.Heros.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerOrderController {
    @Autowired
    private CustomerRepository customerRepository; // Inject CustomerRepository
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    // <?> return type to allow for different body types (either CustomerOrder or an error message).
    @PostMapping("/customer_order")
    public ResponseEntity<?> createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
        try {
            String phoneNumber = customerOrder.getPhoneNumber(); // Extract phoneNumber from the CustomerOrder object
            Long employeeId = customerOrder.getEmployeeId(); // Extract employeeId from the CustomerOrder object
            Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + employeeId));
            customerOrder.setEmployee(employee);
            Customer customer = customerRepository.findByPhoneNumber(phoneNumber) // Then find fk in customer using phoneNumber
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found with phone number: " + phoneNumber)); // throw error


            customerOrder.setCustomer(customer); // Set the customer
            CustomerOrder newCustomerOrder = customerOrderRepository.save(customerOrder);
            return ResponseEntity.ok().body(newCustomerOrder); // return saved customer

        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
