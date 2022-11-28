package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.CustomerController;


import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration.JWT.JwtUtils;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.Address;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.Customer;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.AddaddressDto;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.CustomerRegistrationRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.LoginRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.UserProfileDto;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.CustomerService.CustomerService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RegistrationService.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/get-profile")
    public ResponseEntity<Customer> CustomerInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(customerService.getCustomerProfile(authentication.getName()));
    }

    @GetMapping("/get-address")
    public Set<Address> CustomerAddressInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return customerService.getCustomerAddress(authentication.getName());
    }

    @PutMapping("/update-profile")
    public String CustomerUpdateProfile(@Valid @RequestBody UserProfileDto userProfileDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        customerService.UpdateMyprofile(authentication.getName(), userProfileDto);
        return "profile Updated successfully";
    }

    @PostMapping("/address/add")
    public String addAddress(@Valid @RequestBody AddaddressDto addaddressDto) {
        Authentication authentication = SecurityContextHolder.createEmptyContext().getAuthentication();


    }

//    public CustomerController(RegistrationService registrationService, JwtUtils jwtUtils) {
//        this.registrationService = registrationService;
//        this.jwtUtils            = jwtUtils;
//    }

//    @PostMapping("/register")
//    public String register(@RequestBody CustomerRegistrationRequest request) {
//
//        return registrationService.registerCustomer(request);
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody LoginRequest loginrequest) {
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                new UsernamePasswordAuthenticationToken(loginrequest.getUsername(), loginrequest.getPassword());
//
//        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//        String token = jwtUtils.generateJwtToken(loginrequest.getUsername());
//        return token;
//    }

}

