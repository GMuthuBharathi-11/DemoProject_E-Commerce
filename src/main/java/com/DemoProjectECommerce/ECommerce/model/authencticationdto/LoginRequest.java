package com.DemoProjectECommerce.ECommerce.model.authencticationdto;
import javax.validation.constraints.NotNull;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@SuperBuilder
@Data
public class LoginRequest
{
    @NotNull(message = " Username can't be null")
    private String username;

    @NotNull(message = "password cant be null")
    private String password;
}
