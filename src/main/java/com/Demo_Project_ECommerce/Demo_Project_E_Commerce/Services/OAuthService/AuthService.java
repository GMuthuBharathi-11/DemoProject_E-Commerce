package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.OAuthService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration.JWT.JwtUtils;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.CustomizeErrorHandling.ECommerceApplicationException;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.RefreshToken;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.User;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.AuthenticationResponse;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.LoginRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.RefreshTokenRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.RefreshTokenRepository.RefreshTokenRepository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.UserRepository.UserRepository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RefreshTokenService.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;

@AllArgsConstructor
@Transactional
@Service
public class AuthService {
    private RefreshTokenService refreshTokenService;

    private AuthenticationManager authenticationManager;

    private JwtUtils jwtUtils;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    public AuthenticationResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = jwtUtils.generateJwtToken(loginRequest.getUsername());

        return AuthenticationResponse.builder()
                                     .authenticationToken(token)
                                     .refreshToken(refreshTokenService.generateRefreshToken(loginRequest.getUsername()).getToken())
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

    public AuthenticationResponse getAcessTokenByRefreshToken(String refreshtoken){

        RefreshToken refreshToken= (RefreshToken) refreshTokenRepository.findByToken(refreshtoken)
                                                                        .orElseThrow(()->new ECommerceApplicationException("Invalid Refresh Token"));

        User user= refreshToken.getUser();

        String Token =jwtUtils.generateJwtToken(user.getEmail());

        return AuthenticationResponse.builder()
                                     .authenticationToken(Token)
                                     .refreshToken(refreshTokenService.generateRefreshToken(user.getEmail()).getToken())
                                     .username(user.getEmail())
                                     .expiresAt(Instant.now().plusMillis(jwtUtils.getJwtMillis()))
                                     .build();
    }


}
