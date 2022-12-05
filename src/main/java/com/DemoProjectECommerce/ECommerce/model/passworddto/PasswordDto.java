package com.DemoProjectECommerce.ECommerce.model.passworddto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.NoArgsConstructor;
import lombok.Data;



@Data
@NoArgsConstructor
public class PasswordDto
{
//    @NotNull
//    @Pattern(regexp = "^[a-zA-Z0-9]{3}",message = "enter correct password")
    private String  password;

//    @NotNull
    private String ConfirmPassword;

}
