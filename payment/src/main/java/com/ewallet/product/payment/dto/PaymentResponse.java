package com.ewallet.product.payment.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponse {

    private String transactionId;
    private String status;
    private int amount;
    private int feeAmount;
    private int totalDebit;
    private int merchantCredit;
}

