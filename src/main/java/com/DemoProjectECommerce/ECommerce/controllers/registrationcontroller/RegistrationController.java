package com.DemoProjectECommerce.ECommerce.controllers.registrationcontroller;

import com.DemoProjectECommerce.ECommerce.services.registrationservice.RegistrationService;
import com.DemoProjectECommerce.ECommerce.model.registrationdto.CustomerRegistrationRequest;
import com.DemoProjectECommerce.ECommerce.model.registrationdto.SellerRegistrationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegistrationController
{

    private final RegistrationService registration_service;


    public RegistrationController(RegistrationService registrationService) {
        this.registration_service = registrationService;
    }

    @PostMapping("/customer/register")                                   //customer
    public String register(@Valid @RequestBody CustomerRegistrationRequest customerRegisterRequest) {
        return registration_service.registerCustomer(customerRegisterRequest);
    }

    @PostMapping("/seller/register")
    public String register(@Valid @RequestBody SellerRegistrationRequest sellerRegistrationRequest){
        return registration_service.registerSeller(sellerRegistrationRequest);
    }
}