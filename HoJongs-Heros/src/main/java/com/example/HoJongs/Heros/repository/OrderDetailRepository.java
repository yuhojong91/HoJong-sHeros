package com.example.HoJongs.Heros.repository;

import com.example.HoJongs.Heros.model.Customer;
import com.example.HoJongs.Heros.model.CustomerOrder;
import com.example.HoJongs.Heros.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    Optional<CustomerOrder> findByOrderId(Long order_id);
}
