package com.ewallet.product.payment.dto;

import lombok.Data;

@Data
public class PaymentRequest {

    private Long customerId;
    private Long merchantId;
    private Long productId;
    private String currency;
}


