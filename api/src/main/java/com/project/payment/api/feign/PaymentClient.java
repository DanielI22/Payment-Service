package com.project.payment.api.feign;

import com.project.payment.api.model.PaymentRequest;
import com.project.payment.api.model.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "PAYMENT-SERVICE", url = "http://localhost:8092")
public interface PaymentClient {
    @RequestMapping(method = RequestMethod.POST, value = "/payment/")
    PaymentResponse authorizePayment(@RequestBody PaymentRequest paymentRequest);
}
