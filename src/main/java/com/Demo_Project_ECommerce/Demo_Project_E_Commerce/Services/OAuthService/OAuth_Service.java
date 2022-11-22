package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.OAuthService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration.JWT.Jwt_Utils;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.AuthenticationResponse;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.LoginRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.RefreshTokenRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RefreshTokenService.Refresh_Token_Service;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
@Service
@AllArgsConstructor
@Transactional
public class OAuth_Service
{
    private Refresh_Token_Service refreshTokenService;

    private AuthenticationManager authenticationManager;

    private Jwt_Utils jwtUtils;

    public AuthenticationResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = jwtUtils.generateJwtToken(loginRequest.getUsername());

        return AuthenticationResponse.builder()
                                     .authenticationToken(token)
                                     .refreshToken(refreshTokenService.generateRefreshToken().getToken())
                                     .username(loginRequest.getUsername())
                                     .expiresAt(Instant.now().plusMillis(jwtUtils.getJwtMillis()))
                                     .build();
    }

    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {

        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String Token = jwtUtils.generateJwtToken(refreshTokenRequest.getUsername());
        return AuthenticationResponse.builder()
                                     .authenticationToken(Token)
                                     .refreshToken(refreshTokenRequest.getRefreshToken())
                                     .expiresAt(Instant.now().plusMillis(jwtUtils.getJwtMillis()))
                                     .username(refreshTokenRequest.getUsername())
                                     .build();

    }
}
