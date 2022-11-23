package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.AuthController;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration.JWT.JwtUtils;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.AuthenticationResponse;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.LoginRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.RefreshTokenRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.OAuthService.AuthService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RefreshTokenService.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class AuthController
{
//    @Autowired
//    public class Login_Controller {
//
//        @Autowired
//        OAuth_Service authService;
//
//        @Autowired
//        Jwt_Utils jwtUtils;
//
//        @PostMapping("/login")
//        public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginrequest) {
//
//            return ResponseEntity.ok(authService.login(loginrequest));
//        }
//    }
//    @RestController
//    public class Registration_Controller {
//
//        private final Registration_Service registration_service;
//
//
//        public Registration_Controller(Registration_Service registrationService) {
//            this.registration_service = registrationService;
//        }
//
//        @PostMapping("/customer/register")                                   //customer
//        public String register(@RequestBody CustomerRegistrationRequest customerRegisterRequest) {
//            return registration_service.registerCustomer(customerRegisterRequest);
//        }
//
//        @PostMapping("/seller/register")
//        public String register(@RequestBody SellerRegistrationRequest sellerRegisterRequest) {
//            return registration_service.registerSeller(sellerRegisterRequest);
//        }
//    }
    @Autowired
    AuthService authService;
    @Autowired
    JwtUtils    jwtUtils;
    @Autowired
    private RefreshTokenService refreshTokenService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest)
    {
        return ResponseEntity.ok(authService.login(loginRequest));
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest)
    {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.ok(("Refresh Token Deleted Successfully"));
    }
}
