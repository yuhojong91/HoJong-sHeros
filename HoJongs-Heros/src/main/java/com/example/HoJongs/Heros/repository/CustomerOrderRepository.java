package com.example.HoJongs.Heros.repository;

import com.example.HoJongs.Heros.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
