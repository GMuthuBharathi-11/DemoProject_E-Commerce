package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.AuthController;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration.JWT.Jwt_Utils;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.AuthenticationResponse;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.CustomerRegistrationRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.LoginRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.SellerRegistrationRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.OAuthService.OAuth_Service;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RegistrationService.Registration_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

public class OAuth_Controller
{
    @RestController
    public class Login_Controller {

        @Autowired
        OAuth_Service authService;

        @Autowired
        Jwt_Utils jwtUtils;

        @PostMapping("/login")
        public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginrequest) {

            return ResponseEntity.ok(authService.login(loginrequest));
        }
    }
    @RestController
    public class Registration_Controller {

        private final Registration_Service registration_service;


        public Registration_Controller(Registration_Service registrationService) {
            this.registration_service = registrationService;
        }

        @PostMapping("/customer/register")                                   //customer
        public String register(@RequestBody CustomerRegistrationRequest customerRegisterRequest) {
            return registration_service.registerCustomer(customerRegisterRequest);
        }

        @PostMapping("/seller/register")
        public String register(@RequestBody SellerRegistrationRequest sellerRegisterRequest) {
            return registration_service.registerSeller(sellerRegisterRequest);
        }
    }
}
