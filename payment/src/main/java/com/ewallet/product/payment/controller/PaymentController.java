package com.ewallet.product.payment.controller;

import com.ewallet.product.payment.dto.PaymentRequest;
import com.ewallet.product.payment.dto.PaymentResponse;
import com.ewallet.product.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/process")
    public PaymentResponse doPayment(@RequestBody PaymentRequest request) {
        return paymentService.processPayment(request);
    }
}


