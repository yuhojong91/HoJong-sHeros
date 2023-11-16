package com.example.HoJongs.Heros.controller;


import com.example.HoJongs.Heros.model.CustomerOrder;
import com.example.HoJongs.Heros.model.OrderDetail;
import com.example.HoJongs.Heros.repository.CustomerOrderRepository;
import com.example.HoJongs.Heros.repository.OrderDetailRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrderDetailController {
//    @Autowired
//    private ProductRepository productRepository; //Inject EmployeeRepository
    @Autowired
    private CustomerOrderRepository customerOrderRepository; //Inject CustomerOrderRepository
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    // <?> return type to allow for different body types (either OrderDetail or an error message).
    @PostMapping("/order_detail")
    public ResponseEntity<?> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        try {
            Long customerOrderId = orderDetail.getOrderId();
            CustomerOrder customerOrder = customerOrderRepository.getReferenceById(customerOrderId); // Extract CustomerOrder affiliated with order detail
            orderDetail.setOrder(customerOrder); // Set Order in orderDetail to affiliated order
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        try {
            Long productId = orderDetail.getProductId();
            Product product = productRepository.getReferenceById(productId); // Extract Product affiliated with order detail
            orderDetail.setProduct(product); // set Product in orderDetail to affiliated product
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        orderDetail.setPrice(orderDetail.getQuantity() * orderDetail.getProduct().getPrice() * (1 - orderDetail.getDiscount())); // generate price from product and quantity
        CustomerOrder order = orderDetail.getOrder();
        order.setTotalPrice(order.getTotalPrice() + orderDetail.getPrice());
        customerOrderRepository.save(order);
        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail); // save orderDetail to repository
        return ResponseEntity.ok().body(newOrderDetail);
    }

    @GetMapping("/order_detail")
    public ResponseEntity<?> fetchOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailRepository.findAll();
        return ResponseEntity.ok().body(orderDetails);
    }

    @GetMapping("/order_detail/{id}")
    public ResponseEntity<?> fetchOrderDetailByOrder(@PathVariable("id") Long customerOrderId) {
        Optional<CustomerOrder> orderDetails = orderDetailRepository.findByOrderId(customerOrderId);
        return ResponseEntity.ok().body(orderDetails);
    }
}
