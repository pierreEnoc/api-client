package com.client.api.dto.wsraspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private String id;
    private String cpf;
    private String emaIl;
    private String firstName;
    private String lastName;
}
