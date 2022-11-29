package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class AddaddressDto
{
    private  String city;
    @NotNull
    private String label;
    private String state;
    @NotNull
    private String addressLine;
   // @Pattern(regexp="^[a-zA-Z0-9]{3}",message="Incorrect zip format")
    private String zipCode;
    @NotNull
    private String country;
}
