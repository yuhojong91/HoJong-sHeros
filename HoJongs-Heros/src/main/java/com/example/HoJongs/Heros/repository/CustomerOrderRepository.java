package com.example.HoJongs.Heros.repository;

import com.example.HoJongs.Heros.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    //The findByCustomer_ZipCodeAndDateTimeBetween method in Spring Data JPA initiates a query (findBy) to filter CustomerOrder records by the zipCode property of the associated Customer entity (Customer_ZipCode), and further narrows the results to records where the dateTime property falls within a specified range (DateTimeBetween), combining these criteria with And.
    List<CustomerOrder> findByCustomer_ZipCodeAndDateTimeBetween(String zipCode, LocalDate startDateTime, LocalDate endDateTime);
}
