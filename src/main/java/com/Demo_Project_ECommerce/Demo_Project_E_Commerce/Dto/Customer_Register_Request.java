package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class Customer_Register_Request extends UserDetails
{
    private String Contact_Number;

}
