package com.ewallet.product.payment.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "productName")
    private String productName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "cost")
    private int cost;

    @Column(name = "currency")
    private String currency;

    @ManyToOne
    @JoinColumn(name = "merchant_id")   // FK
    private Merchant merchant;
}