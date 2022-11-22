package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.CustomerController;


import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration.JWT.Jwt_Utils;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.CustomerRegistrationRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.LoginRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RegistrationService.Registration_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/registration")
public class CustomerController {
    private final Registration_Service registrationService;
    private final Jwt_Utils            jwtUtils;
    @Autowired
    AuthenticationManager authenticationManager;

    public CustomerController(Registration_Service registrationService, Jwt_Utils jwtUtils) {
        this.registrationService = registrationService;
        this.jwtUtils            = jwtUtils;
    }

    @PostMapping("/register")
    public String register(@RequestBody CustomerRegistrationRequest request) {

        return registrationService.registerCustomer(request);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginrequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginrequest.getUsername(), loginrequest.getPassword());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        String token = jwtUtils.generateJwtToken(loginrequest.getUsername());
        return token;
    }




}

