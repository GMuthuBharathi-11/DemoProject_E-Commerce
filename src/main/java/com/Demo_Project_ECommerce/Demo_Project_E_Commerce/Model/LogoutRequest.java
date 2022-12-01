package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
public class LogoutRequest
{
    @NotNull(message = "username cant be null")
    private String username;

    @NotNull(message = "Password cant be null")
    private String password;
}
