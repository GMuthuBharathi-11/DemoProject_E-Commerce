package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class PasswordDto
{
    @NotNull
//    @Pattern(regexp = "",message = )
    private String  password;
    @NotNull
    private String ConfirmPassword;



}
