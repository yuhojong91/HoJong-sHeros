 package com.example.HoJongs.Heros.model;

 import jakarta.persistence.*;

 import java.time.LocalDateTime;
 import java.util.Set;

 @Entity
 public class CustomerOrder {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long Id;
     private String phoneNumber;
     private String dateTime;
     private Double totalPrice;
     //@JoinColumn in @ManyToOne specifies the column used for joining to the referenced entity.
     //ReferencedColumnName tells Hibernate that this fk column is referring to the 'Id' columnn in the 'Customer' table
     @ManyToOne
     @JoinColumn(name = "customer_id", referencedColumnName = "Id")
     private Customer customer;

     @OneToMany(mappedBy = "order")
     private Set<OrderDetail> orderDetails;

//     @ManyToOne
//     @JoinColumn(name = "employee_id", referencedColumnName)
//     private Employee employee;

     public CustomerOrder(){
     }
     public CustomerOrder(String phoneNumber, String dateTime) {
         this.phoneNumber = phoneNumber;
         this.dateTime = dateTime;
         this.totalPrice = 0.;
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

     public Double getTotalPrice() {
         return totalPrice;
     }

     public void setTotalPrice(Double totalPrice) {
         this.totalPrice = totalPrice;
     }

     public void setCustomer(Customer customer) {
         this.customer = customer;
     }
 }
