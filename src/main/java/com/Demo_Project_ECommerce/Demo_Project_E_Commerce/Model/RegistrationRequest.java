package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    @Email(message = "invalid email")
    private String email;
    @NotNull
    private String password;

}
