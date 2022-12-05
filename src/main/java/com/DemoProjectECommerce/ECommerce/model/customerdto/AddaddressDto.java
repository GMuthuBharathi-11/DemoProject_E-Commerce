package com.DemoProjectECommerce.ECommerce.model.customerdto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.NoArgsConstructor;
import lombok.Data;



@Data
@NoArgsConstructor
public class AddaddressDto
{
    @Size(min=3,message = "city should contain at least 3 letters")
    private  String city;
    private String state;
    private String country;
    @NotNull
    private String label;
    @NotNull
    private String addressLine;
    @Pattern(regexp="^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$",message="Incorrect zip format")
    private String zipCode;


}
