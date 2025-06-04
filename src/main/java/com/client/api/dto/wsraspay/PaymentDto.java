package com.client.api.dto.wsraspay;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    private CreditCardDto creditCard;
    private String customerId;
    private String orderId;
}
