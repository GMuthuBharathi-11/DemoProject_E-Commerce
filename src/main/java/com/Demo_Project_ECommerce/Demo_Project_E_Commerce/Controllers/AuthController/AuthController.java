package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.AuthController;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration.JWT.JwtUtils;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.AuthenticationResponse;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.LoginRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.RefreshTokenRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.OAuthService.AuthService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RefreshTokenService.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class AuthController
{
    @Autowired
    AuthService authService;
    @Autowired
    JwtUtils    jwtUtils;
    @Autowired
    private RefreshTokenService refreshTokenService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@Valid @RequestBody LoginRequest loginRequest)
    {
        return ResponseEntity.ok(authService.login(loginRequest));
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest)
    {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.ok(("Refresh Token Deleted Successfully"));
    }
    @GetMapping("/access-refresh-token")
    public ResponseEntity<AuthenticationResponse> accessTokenWithRefreshToken(@RequestParam("Token")String Token) {
        return ResponseEntity.ok(authService.getAcessTokenByRefreshToken(Token));
    }
}
