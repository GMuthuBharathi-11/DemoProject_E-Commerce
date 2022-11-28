package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
public class UserProfileDto {
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String City;
    private String State;
    private String Country;
    private String Address_Line;
    private String Zip_Code;
    private String Label;
    private String ContactNo;
    @javax.validation.constraints.Email
    private String Email;
    @NotNull
    private String Password;
}
