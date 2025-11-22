package com.ewallet.product.payment.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer_account")
@Data
public class CustomerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "currency")
    private String currency;

    @Column(name = "balance")
    private int balance;

    @Column(name = "account_no")
    private String accountNo;
}
