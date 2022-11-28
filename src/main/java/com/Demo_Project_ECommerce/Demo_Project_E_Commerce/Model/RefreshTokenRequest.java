package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenRequest
{
    @NotBlank
    private String refreshToken;
    private String username;
}
