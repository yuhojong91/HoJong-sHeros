// package com.example.HoJongs.Heros.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;

// import java.time.LocalDateTime;
// @Entity
// public class CustomerOrder {
//     @Id
//     private Long Id;
//     private String phone_number;
//     private LocalDateTime date_time;
//     private double total_price;
//     //@JoinColumn in @ManyToOne specifies the column used for joining to the referenced entity.
//     @ManyToOne
//     @JoinColumn(name = "phone_number")
//     private Customer customer;

//     @ManyToOne
//     @JoinColumn(name = "employee_id")
//     private Employee employee;

//     public CustomerOrder(){
//     }
//     public CustomerOrder(String phone_number, LocalDateTime date_time, double total_price) {
//         this.phone_number = phone_number;
//         this.date_time = date_time;
//         this.total_price = total_price;
//     }

//     public Long getId() {
//         return Id;
//     }

//     public String getPhone_number() {
//         return phone_number;
//     }

//     public void setPhone_number(String phone_number) {
//         this.phone_number = phone_number;
//     }

//     public LocalDateTime getDate_time() {
//         return date_time;
//     }

//     public void setDate_time(LocalDateTime date_time) {
//         this.date_time = date_time;
//     }

//     public double getTotal_price() {
//         return total_price;
//     }

//     public void setTotal_price(double total_price) {
//         this.total_price = total_price;
//     }
// }
