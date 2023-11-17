 package com.example.HoJongs.Heros.model;

 import jakarta.persistence.*;

 import java.math.BigInteger;
 @Entity
 public class OrderDetail {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long Id;
     @Column(insertable=false, updatable=false)
     private Long orderId;
     @Column(insertable=false, updatable=false)
     private Long productId;
     private BigInteger quantity;
     private double discount;
     private double price;

     @ManyToOne
     @JoinColumn(name = "orderId", referencedColumnName = "Id")
     private CustomerOrder order;

     @ManyToOne
     @JoinColumn(name = "productId", referencedColumnName = "Id")
     private Product product;

     public OrderDetail() {
     }

     public OrderDetail(BigInteger quantity, double discount, Long orderId, Long productId) {
         this.quantity = quantity;
         this.discount = discount;
         this.price = 0;
         this.orderId = orderId;
         this.productId = productId;
     }

     public OrderDetail(BigInteger quantity, Long orderId, Long productId) {
         this.quantity = quantity;
         this.discount = 0;
         this.price = 0;
         this.orderId = orderId;
         this.productId = productId;
     }

     public Long getId() { return Id; }

     public Long getOrderId() { return orderId; }
     public void setOrderId(Long orderId) {this.orderId = orderId; }

     public Long getProductId() { return productId; }
     public void setProductId(Long productId) {this.productId = productId; }

     public BigInteger getQuantity() { return quantity; }
     public void setQuantity(BigInteger quantity) { this.quantity = quantity; }

     public double getDiscount() { return discount; }
     public void setDiscount(double discount) { this.discount = discount; }

     public double getPrice() { return price; }
     public void setPrice(double price) { this.price = price; }

     public CustomerOrder getOrder() { return order; }
     public void setOrder(CustomerOrder order) { this.order = order; }

     public Product getProduct() { return product; }
     public void setProduct(Product product) { this.product = product; }
 }
