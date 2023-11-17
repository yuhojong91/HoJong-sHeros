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
    private boolean isActive;
    //mappedBy attribute in @OneToMany is used to specify the field in the child entity that owns the relationship.

    @OneToMany(mappedBy = "employee")
    private Set<CustomerOrder> orders;

    public Employee(){
    }

    public Employee(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }

    public boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }
}
