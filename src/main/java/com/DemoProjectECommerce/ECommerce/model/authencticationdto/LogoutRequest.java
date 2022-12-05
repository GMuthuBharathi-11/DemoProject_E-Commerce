package com.DemoProjectECommerce.ECommerce.model.authencticationdto;

import javax.validation.constraints.NotNull;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@SuperBuilder
@Data
public class LogoutRequest
{
    @NotNull(message = "username cant be null")
    private String username;

    @NotNull(message = "Password cant be null")
    private String password;

}
