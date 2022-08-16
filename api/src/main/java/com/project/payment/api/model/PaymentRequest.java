package com.project.payment.api.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private String cardCredentials;
    private Double ticketPrice;
}
