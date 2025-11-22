package com.ewallet.product.payment.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CustomerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int balance;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}

