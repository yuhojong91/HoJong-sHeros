package com.example.HoJongs.Heros.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Customer {
    @Id
    private String phone_number;
    private String name;
    private String address;
    private String city;
    private String state;
    private Integer zip_code;
    //    //mappedBy attribute in @OneToMany is used to specify the field in the child entity that owns the relationship.
    @OneToMany(mappedBy = "phone_number")
    private Set<CustomerOrder> orders;
    public Customer(){
    }

    public Customer(String phone_number, String name, String address, String city, String state, Integer zip_code) {
        this.phone_number = phone_number;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
    }

    public String getId() {
        return phone_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Integer getZip_code() {
        return zip_code;
    }
}
