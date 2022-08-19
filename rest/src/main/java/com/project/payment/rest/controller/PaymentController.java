package com.project.payment.rest.controller;

import com.project.payment.api.model.PaymentRequest;
import com.project.payment.api.model.PaymentResponse;
import com.project.payment.core.interfaces.PaymentServiceProcessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentServiceProcessor paymentServiceProcessor;

    public PaymentController(PaymentServiceProcessor paymentServiceProcessor) {
        this.paymentServiceProcessor = paymentServiceProcessor;
    }

    @PostMapping("/payment")
    public PaymentResponse authorizePayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentServiceProcessor.authorizePayment(paymentRequest);
    }
}
