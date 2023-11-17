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
     @Column(insertable=false, updatable=false)
     private Long employeeId;
     //@JoinColumn in @ManyToOne specifies the column used for joining to the referenced entity.
     //ReferencedColumnName tells Hibernate that this fk column is referring to the 'Id' columnn in the 'Customer' table
     @ManyToOne
     @JoinColumn(name = "customer_id", referencedColumnName = "Id")
     private Customer customer;

     @OneToMany(mappedBy = "order")
     private Set<OrderDetail> orderDetails;
   
     @ManyToOne
     @JoinColumn(name = "employeeId", referencedColumnName = "Id")
     private Employee employee;

     public CustomerOrder(){
     }
   
     public CustomerOrder(String phoneNumber, String dateTime, Long employeeId) {
         this.phoneNumber = phoneNumber;
         this.dateTime = dateTime;
         this.totalPrice = 0.;
         this.employeeId = employeeId;
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
         if (totalPrice == null) {
             return 0.;
         }
         else {
             return totalPrice;
         }

     }
     public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

     public Long getEmployeeId() { return employeeId; }
     public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

     public Customer getCustomer() { return customer; }
     public void setCustomer(Customer customer) { this.customer = customer; }

     public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
 }
