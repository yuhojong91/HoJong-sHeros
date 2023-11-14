// package com.example.HoJongs.Heros.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;

// import java.util.Set;

// @Entity
// public class Product {
//     @Id
//     private Long Id;
//     private String name;
//     private String description;
//     private Double price;
//     @OneToMany(mappedBy = "product")
//     private Set<OrderDetail> orderDetails;
//     public Product(){}

//     public Product(String name, String description, Double price, Set<OrderDetail> orderDetails) {
//         this.name = name;
//         this.description = description;
//         this.price = price;
//         this.orderDetails = orderDetails;
//     }

//     public Long getId() {
//         return Id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public Double getPrice() {
//         return price;
//     }

//     public void setPrice(Double price) {
//         this.price = price;
//     }

//     public Set<OrderDetail> getOrderDetails() {
//         return orderDetails;
//     }

//     public void setOrderDetails(Set<OrderDetail> orderDetails) {
//         this.orderDetails = orderDetails;
//     }
// }
