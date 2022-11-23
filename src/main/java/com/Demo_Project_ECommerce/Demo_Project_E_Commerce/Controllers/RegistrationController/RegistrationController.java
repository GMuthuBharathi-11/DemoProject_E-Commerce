package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.RegistrationController;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.CustomerRegistrationRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.SellerRegistrationRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RegistrationService.RegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController
{
    private final RegistrationService registration_service;


    public RegistrationController(RegistrationService registrationService) {
        this.registration_service = registrationService;
    }

    @PostMapping("/customer/register")                                   //customer
    public String register(@RequestBody CustomerRegistrationRequest customerRegisterRequest) {
        return registration_service.registerCustomer(customerRegisterRequest);
    }

    @PostMapping("/seller/register")
    public String register(@RequestBody SellerRegistrationRequest  sellerRegistrationRequest){
        return registration_service.registerSeller(sellerRegistrationRequest);
    }
}