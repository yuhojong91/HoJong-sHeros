package com.example.HoJongs.Heros.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
 import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List; 
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private boolean is_active;
    //mappedBy attribute in @OneToMany is used to specify the field in the child entity that owns the relationship.

    @OneToMany(mappedBy = "employee")
    // @JoinColumn(name = "order_id",referencedColumnName = "Id")
    private Set<CustomerOrder> orders;

    public Employee(){
    }

    public Employee(String name, boolean is_active) {
        this.name = name;
        this.is_active = is_active;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id){
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public boolean isIs_active() {
        return is_active;
    }


}
