package com.example.HoJongs.Heros.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String phoneNumber;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    //mappedBy attribute in @OneToMany is used to specify the field in the child entity that owns the relationship.
     @OneToMany(mappedBy = "customer")
     private Set<CustomerOrder> orders;
    public Customer(){
    }

    public Customer(String phoneNumber, String name, String address, String city, String state, String zipCode) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getId() {
        return phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber; }

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name; }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {this.address = address; }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {this.city = city; }

    public String getState() {
        return state;
    }
    public void setState(String state) {this.state = state; }

    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {this.zipCode = zipCode; }
}
