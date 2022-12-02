package com.DemoProjectECommerce.ECommerce.model.customerdto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class AddressUpdateDto
{
    @Size(min=2)
    private  String city;
    @NotNull
    private String label;
    private String state;
    @NotNull
    private String addressLine;
    //@Pattern(regexp="^[a-zA-Z0-9]{3}",message="Incorrect zip format")
    private String zipCode;
    @NotNull
    private String country;
}
