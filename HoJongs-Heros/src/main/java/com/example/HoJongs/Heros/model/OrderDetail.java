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
    private BigInteger quantity;
    private double discount;
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private CustomerOrder order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    public OrderDetail(){
    }

    public OrderDetail(BigInteger quantity, double discount, double price, CustomerOrder order, Product product) {
        this.quantity = quantity;
        this.discount = discount;
        this.price = price;
        this.order = order;
        this.product = product;
    }

    public Long getId() {
        return Id;
    }


    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CustomerOrder getOrder() {
        return order;
    }

    public void setOrder(CustomerOrder order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
