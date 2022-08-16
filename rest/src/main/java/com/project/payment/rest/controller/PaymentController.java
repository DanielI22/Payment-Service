package com.project.payment.rest.controller;

import com.project.payment.api.model.PaymentRequest;
import com.project.payment.api.model.PaymentResponse;
import com.project.payment.core.interfaces.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public PaymentResponse authorizePayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.authorizePayment(paymentRequest);
    }
}
