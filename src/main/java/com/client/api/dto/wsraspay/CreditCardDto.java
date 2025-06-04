package com.client.api.dto.wsraspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDto {
    private String cvv;
    private String documentNumber;
    private Long installments;
    private Long month;
    private String number;
    private String year;
}
