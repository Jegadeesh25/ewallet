package com.ewallet.product.payment.controller;

import com.ewallet.product.payment.dto.PaymentRequest;
import com.ewallet.product.payment.dto.PaymentResponse;
import com.ewallet.product.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class paymentController {

    private final PaymentService paymentService;

    @PostMapping("/process")
    public PaymentResponse process(@RequestBody PaymentRequest request) {
        return paymentService.processPayment(request);
    }
}

