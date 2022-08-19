package com.project.payment.core.implementation;

import com.project.payment.api.model.PaymentRequest;
import com.project.payment.api.model.PaymentResponse;
import com.project.payment.core.interfaces.PaymentServiceProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceProcessorCore implements PaymentServiceProcessor {
    @Override
    public PaymentResponse authorizePayment(PaymentRequest paymentRequest) {
        if(paymentRequest.getCardCredentials().length() < 5 || paymentRequest.getCardCredentials().length() > 10) {
            return PaymentResponse.builder()
                    .responseStatus(HttpStatus.BAD_REQUEST).build();
        }
        else if(paymentRequest.getCardCredentials().endsWith("5")) {
            return PaymentResponse.builder()
                    .responseStatus(HttpStatus.PAYMENT_REQUIRED).build();
        }
        return PaymentResponse.builder().responseStatus(HttpStatus.ACCEPTED).build();
    }
}
