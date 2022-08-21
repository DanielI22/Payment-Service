package com.project.payment.core.implementation;

import com.project.payment.api.model.PaymentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceProcessorCoreTest {
    private PaymentServiceProcessorCore paymentServiceProcessorCore;

    @BeforeEach
    public void setup() {
        paymentServiceProcessorCore = new PaymentServiceProcessorCore();
    }

    @Test
    public void acceptedPaymentTest() {
        var payment = PaymentRequest.builder().cardCredentials("000000000").ticketPrice(10.).build();
        assertEquals(HttpStatus.ACCEPTED, paymentServiceProcessorCore.authorizePayment(payment).getResponseStatus());
    }

    @Test
    public void invalidCredentialsLengthTooShortPaymentTest() {
        var payment = PaymentRequest.builder().cardCredentials("0").ticketPrice(10.).build();
        assertEquals(HttpStatus.BAD_REQUEST, paymentServiceProcessorCore.authorizePayment(payment).getResponseStatus());
    }

    @Test
    public void invalidCredentialsLengthTooLongPaymentTest() {
        var payment = PaymentRequest.builder().cardCredentials("00000000000000000000").ticketPrice(10.).build();
        assertEquals(HttpStatus.BAD_REQUEST, paymentServiceProcessorCore.authorizePayment(payment).getResponseStatus());
    }

    @Test
    public void insufficientBalanceCredentialsPaymentTest() {
        var payment = PaymentRequest.builder().cardCredentials("00000005").ticketPrice(10.).build();
        assertEquals(HttpStatus.PAYMENT_REQUIRED, paymentServiceProcessorCore.authorizePayment(payment).getResponseStatus());
    }
}