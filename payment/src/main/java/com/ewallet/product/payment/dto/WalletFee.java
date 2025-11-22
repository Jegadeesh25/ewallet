package com.ewallet.product.payment.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "wallet_fee")
@Data
public class WalletFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "fee")
    private int fee;
}
