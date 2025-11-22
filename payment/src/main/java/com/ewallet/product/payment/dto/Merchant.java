package com.ewallet.product.payment.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "merchant")
@Data
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merchant_id")
    private Long id;

    @Column(name = "merchantName")
    private String name;

    @Column(name = "merchantPhoneNo")
    private String phoneNo;

    @Column(name = "merchantAccountNo")
    private String accountNo;

    @Column(name = "amount")
    private int amount;

    @Column(name = "currency")
    private String currency;
}