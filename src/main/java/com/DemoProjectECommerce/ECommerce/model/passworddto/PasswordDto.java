package com.DemoProjectECommerce.ECommerce.model.passworddto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
