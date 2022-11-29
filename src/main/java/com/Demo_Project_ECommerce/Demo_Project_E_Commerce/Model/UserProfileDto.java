package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
public class UserProfileDto {
    private String firstName;
    private String middleName;
    private String lastName;
    @javax.validation.constraints.Email
    @JoinColumn(unique = true)
    private String email;
    @NotNull
    private String contactNo;
}
