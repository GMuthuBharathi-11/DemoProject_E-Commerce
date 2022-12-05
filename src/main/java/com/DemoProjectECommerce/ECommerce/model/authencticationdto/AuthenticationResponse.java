package com.DemoProjectECommerce.ECommerce.model.authencticationdto;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.Instant;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse
{
    private String  authenticationToken;
    private String  refreshToken;
    private Instant expiresAt;
    private String  username;
}
