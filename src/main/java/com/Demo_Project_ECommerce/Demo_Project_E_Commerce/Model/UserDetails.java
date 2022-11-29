package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.asm.Advice;

import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
public class UserDetails
{
    private String firstName;
    private String middleName;
    private String lastName;
    private String city;
    private String state;
    private String country;
    private String addressLine;
    private String zipCode;
    private String label;
    @Email
    @JoinColumn(unique = true)
    private String email;
    @NotNull
    private String password;
    private LocalDateTime passwordCreatedDate;


}
