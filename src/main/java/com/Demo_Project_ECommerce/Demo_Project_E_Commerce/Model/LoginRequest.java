package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
public class LoginRequest
{
//    @NotNull(message = " Username can't be null")
    private String username;
//    @NotNull(message = "password cant be null")
    private String password;
}
