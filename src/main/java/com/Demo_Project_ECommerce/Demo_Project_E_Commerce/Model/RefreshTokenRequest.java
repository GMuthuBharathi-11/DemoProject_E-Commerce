package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenRequest
{
    @NotBlank(message = "refresh token cant be null")
    private String refreshToken;
    @NotNull(message = "username cant be null")
    private String username;
}
