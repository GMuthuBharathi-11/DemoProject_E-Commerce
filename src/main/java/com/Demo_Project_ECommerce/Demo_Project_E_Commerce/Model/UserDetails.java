package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
public class UserDetails
{
    private String First_Name;
    private String Middle_Name;
    private String Last_Name;
    private String City;
    private String State;
    private String Country;
    private String Address_Line;
    private String Zip_Code;
    private String Label;
    @Email
    private String Email;
    @NotNull
    private String Password;


}
