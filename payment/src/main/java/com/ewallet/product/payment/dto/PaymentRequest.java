package com.ewallet.product.payment.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {

    private Long customerId;
    private Long merchantId;
    private Long productId;
    private int amount;
    private String currency;
}


