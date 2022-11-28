package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Service
public class AddaddressDto
{
    private  String City;
    @NotNull
    private String Label;
    private String State;
    @NotNull
    private String AddressLine;
    @Pattern(regexp="^[a-zA-Z0-9]{3}",message="Incorrect zip format")
    private String ZipCode;
    @NotNull
    private String Country;
}
