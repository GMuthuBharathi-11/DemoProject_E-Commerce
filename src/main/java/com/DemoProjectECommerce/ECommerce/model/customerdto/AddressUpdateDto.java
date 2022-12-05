package com.DemoProjectECommerce.ECommerce.model.customerdto;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class AddressUpdateDto
{
    @Size(min=3)
    private  String city;
    private String state;
    private String country;
    private String addressLine;
    @Pattern(regexp="^[1-9][0-9]{5}$",message="Incorrect zip format")
    private String zipCode;
    private String label;

}
