package com.DemoProjectECommerce.ECommerce.services.oauthservice;

import com.DemoProjectECommerce.ECommerce.customizehandling.ECommerceApplicationException;

import com.DemoProjectECommerce.ECommerce.entity.RefreshToken;
import com.DemoProjectECommerce.ECommerce.entity.User;
import com.DemoProjectECommerce.ECommerce.model.authencticationdto.RefreshTokenRequest;
import com.DemoProjectECommerce.ECommerce.repositories.userrepository.UserRepository;
import com.DemoProjectECommerce.ECommerce.configuration.JWT.JwtUtils;
import com.DemoProjectECommerce.ECommerce.model.authencticationdto.AuthenticationResponse;
import com.DemoProjectECommerce.ECommerce.model.authencticationdto.LoginRequest;
import com.DemoProjectECommerce.ECommerce.repositories.refreshtokenrepository.RefreshTokenRepository;
import com.DemoProjectECommerce.ECommerce.services.refreshtokenservice.RefreshTokenService;
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

    private JwtUtils               jwtUtils;
    @Autowired
    private UserRepository         userRepository;
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

        User user = refreshToken.getUser();

        String Token =jwtUtils.generateJwtToken(user.getEmail());

        return AuthenticationResponse.builder()
                                     .authenticationToken(Token)
                                     .refreshToken(refreshTokenService.generateRefreshToken(user.getEmail()).getToken())
                                     .username(user.getEmail())
                                     .expiresAt(Instant.now().plusMillis(jwtUtils.getJwtMillis()))
                                     .build();
    }


}
