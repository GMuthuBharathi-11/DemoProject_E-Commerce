package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class CustomerRegistrationRequest extends UserDetails
{
    private String Contact_Number;

}
