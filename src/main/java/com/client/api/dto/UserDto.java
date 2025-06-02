package com.client.api.dto;

import com.client.api.model.SubscriptionType;
import com.client.api.model.UserType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 6, message = "must be at least 6 characters long")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 11, max = 11, message = "Phone number must be exactly 11 digits")
    private String phone;

    @CPF(message = "CPF should be valid")
    private String cpf;

    private LocalDate dtSubscription = LocalDate.now();

    private LocalDate dtExpiration = LocalDate.now();

    @NotNull(message = "User type cannot be null")
    private Long  userTypeId;

    //@Column(name = "subscriptions_type_id")
    private Long subscriptionsTypeId;
}
