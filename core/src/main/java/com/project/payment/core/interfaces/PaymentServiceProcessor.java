package com.project.payment.core.interfaces;

import com.project.payment.api.model.PaymentRequest;
import com.project.payment.api.model.PaymentResponse;
import org.springframework.http.ResponseEntity;

public interface PaymentServiceProcessor {
    PaymentResponse authorizePayment(PaymentRequest paymentRequest);
}
