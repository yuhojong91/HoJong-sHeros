package com.example.HoJongs.Heros.controller;


import com.example.HoJongs.Heros.model.OrderDetail;
import com.example.HoJongs.Heros.model.Product;
import com.example.HoJongs.Heros.model.CustomerOrder;
import com.example.HoJongs.Heros.repository.CustomerOrderRepository;
import com.example.HoJongs.Heros.repository.OrderDetailRepository;
import com.example.HoJongs.Heros.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrderDetailController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @PostMapping("/order_detail")
    public ResponseEntity<?> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        try {
            Long orderId = orderDetail.getOrderId(); // Fetch ID for both related objects
            Long productId = orderDetail.getProductId();

            CustomerOrder customerOrder = customerOrderRepository.findById(orderId)
                    .orElseThrow(() -> new EntityNotFoundException("Order not found with ID: " + orderId));
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + productId));

            orderDetail.setOrder(customerOrder);
            orderDetail.setProduct(product);
            Double price = orderDetail.getProduct().getPrice() * orderDetail.getQuantity().doubleValue(); // Calculates price from product price and quantity
            price = (double) Math.round(price * 100); // Rounds price to two decimal places
            price = price / 100;
            orderDetail.setPrice(price);

            customerOrder.setTotalPrice(customerOrder.getTotalPrice() + price);
            customerOrderRepository.save(customerOrder); // Add price to total price of associated CustomerOrder

            OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
            return ResponseEntity.ok().body(newOrderDetail); // return saved customer
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/order_detail")
    public List<OrderDetail> getAllOrderDetail() { return orderDetailRepository.findAll(); }

//    @GetMapping("/order_detail/{id}")
//    public ResponseEntity<?> getOrderDetailByOrderId(@PathVariable(value = "id") Long Id) {
//        Optional<OrderDetail> orderDetails = orderDetailRepository.findAll();
//        return ResponseEntity.ok().body(orderDetails);
//    }
}

