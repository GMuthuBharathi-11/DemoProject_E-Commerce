package com.DemoProjectECommerce.ECommerce.model.registrationdto;

import lombok.Getter;
import lombok.Setter;

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
