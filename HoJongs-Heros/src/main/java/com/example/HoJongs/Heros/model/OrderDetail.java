 package com.example.HoJongs.Heros.model;

 import jakarta.persistence.Entity;
 import jakarta.persistence.GeneratedValue;
 import jakarta.persistence.GenerationType;
 import jakarta.persistence.Id;
 import jakarta.persistence.JoinColumn;
 import jakarta.persistence.ManyToOne;

 import java.math.BigInteger;
 @Entity
 public class OrderDetail {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long Id;
     private Long order_id;
     private Long product_id;
     private BigInteger quantity;
     private double discount;
     private double price;

     @ManyToOne
     @JoinColumn(name = "order_id", referencedColumnName = "Id")
     private CustomerOrder order;

     @ManyToOne
     @JoinColumn(name = "product_id", referencedColumnName = "Id")
     private Product product;
     public OrderDetail(){
     }

     public OrderDetail(BigInteger quantity, double discount, Long order_id, Long product_id) { //Product product removed from constructor for testing
         this.quantity = quantity;
         this.discount = discount;
         this.price = 0;
         this.order_id = order_id;
         this.product = product;
         this.product_id = product_id;
     }

     public Long getId() { return Id; }

     public Long getOrderId() { return order_id; }
     public void setOrderId(Long order_id) {this.order_id = order_id; }

     public Long getProductId() { return product_id; }
     public void setProductId(Long product_id) {this.product_id = product_id; }

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
