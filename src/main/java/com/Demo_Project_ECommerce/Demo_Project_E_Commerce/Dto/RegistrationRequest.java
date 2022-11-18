package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@Getter
@Setter
public class RegistrationRequest
{
    private String FirstName;
    private String LastName;
    @Email
    private String Email;
    @NotNull
    private String Password;

}
