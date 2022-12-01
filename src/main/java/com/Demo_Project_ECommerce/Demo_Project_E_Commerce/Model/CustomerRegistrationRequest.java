package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@SuperBuilder
@NoArgsConstructor
public class CustomerRegistrationRequest extends UserDetails
{
//    @NotNull
//    @Pattern(regexp = "[0-9]",message = "Incorrect phone number")
    private String contactNumber;

}
