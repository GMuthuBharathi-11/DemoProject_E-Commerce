package com.DemoProjectECommerce.ECommerce.model.userdto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
public class UserProfileDto {
    private String firstName;
    private String middleName;
    private String lastName;
    @Email
    @JoinColumn(unique = true)
    private String email;
    @NotNull
    private String contactNo;
}
