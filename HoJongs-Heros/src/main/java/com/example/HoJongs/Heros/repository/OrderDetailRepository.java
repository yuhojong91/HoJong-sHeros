package com.example.HoJongs.Heros.repository;


import com.example.HoJongs.Heros.model.Customer;
import com.example.HoJongs.Heros.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrderId(Long orderId);
}
