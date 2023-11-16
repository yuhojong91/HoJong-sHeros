package com.example.HoJongs.Heros.repository;


import com.example.HoJongs.Heros.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //Optional is a container object which may or may not contain a non-null value.
    //findByPhoneNumber: The name of the method dictates the query that Spring Data JPA will construct.
    //It implies a query that finds a Customer entity based on the phoneNumber field.
    Optional<Customer> findByPhoneNumber(String phoneNumber);
}
