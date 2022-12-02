package com.DemoProjectECommerce.ECommerce.controllers.authcontroller;

import com.DemoProjectECommerce.ECommerce.configuration.JWT.JwtUtils;
import com.DemoProjectECommerce.ECommerce.model.authencticationdto.AuthenticationResponse;
import com.DemoProjectECommerce.ECommerce.model.authencticationdto.RefreshTokenRequest;
import com.DemoProjectECommerce.ECommerce.services.oauthservice.AuthService;
import com.DemoProjectECommerce.ECommerce.services.refreshtokenservice.RefreshTokenService;
import com.DemoProjectECommerce.ECommerce.model.authencticationdto.LoginRequest;
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
