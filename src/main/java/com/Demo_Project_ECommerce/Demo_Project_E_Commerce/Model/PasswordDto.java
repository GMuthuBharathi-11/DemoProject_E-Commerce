package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PasswordDto
{
    @NotNull
    private String  password;
    @NotNull
    private String ConfirmPassword;



}
