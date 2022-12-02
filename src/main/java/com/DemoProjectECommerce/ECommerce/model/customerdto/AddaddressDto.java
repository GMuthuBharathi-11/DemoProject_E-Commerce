package com.DemoProjectECommerce.ECommerce.model.customerdto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class AddaddressDto
{
   // @Size(min=3,message = "city should contain at least 3 letters")
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
