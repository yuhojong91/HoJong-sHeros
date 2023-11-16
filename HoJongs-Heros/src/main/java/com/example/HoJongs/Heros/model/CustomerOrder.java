 package com.example.HoJongs.Heros.model;

 import jakarta.persistence.Entity;
 import jakarta.persistence.Id;
 import jakarta.persistence.JoinColumn;
 import jakarta.persistence.ManyToOne;
 import jakarta.persistence.GeneratedValue;
 import jakarta.persistence.GenerationType;
 import java.time.LocalDateTime;
 @Entity
 public class CustomerOrder {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long Id;
     private String phoneNumber;
     private String dateTime;
     private String totalPrice;
     //@JoinColumn in @ManyToOne specifies the column used for joining to the referenced entity.
     //ReferencedColumnName tells Hibernate that this fk column is referring to the 'Id' columnn in the 'Customer' table
     @ManyToOne
     @JoinColumn(name = "customer_id", referencedColumnName = "Id")
     private Customer customer;

//     @ManyToOne
//     @JoinColumn(name = "employee_id")
//     private Employee employee;

     public CustomerOrder(){
     }
     public CustomerOrder(String phoneNumber, String dateTime, String totalPrice) {
         this.phoneNumber = phoneNumber;
         this.dateTime = dateTime;
         this.totalPrice = totalPrice;
     }

     public Long getId() {
         return Id;
     }

     public String getPhoneNumber() {
         return phoneNumber;
     }

     public void setPhoneNumber(String phoneNumber) {
         this.phoneNumber = phoneNumber;
     }

     public String getDateTime() {
         return dateTime;
     }

     public void setDateTime(String dateTime) {
         this.dateTime = dateTime;
     }

     public String getTotalPrice() {
         return totalPrice;
     }

     public void setTotalPrice(String totalPrice) {
         this.totalPrice = totalPrice;
     }

     public void setCustomer(Customer customer) {
         this.customer = customer;
     }
 }
