package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.RegistrationController;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.Customer_Register_Request;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.SellerRegistrationRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RegistrationService.Registration_Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class Registration_controller
{
    private final Registration_Service registration_service;

    private final SellerRegistrationRequest sellerRegistrationRequest;

    public Registration_controller(Registration_Service registrationService, SellerRegistrationRequest sellerRegisterRequest) {
        this.registration_service = registrationService;
        this.sellerRegistrationRequest = sellerRegisterRequest;
    }

    @PostMapping("/customer/register")                                   //customer
    public String register(@RequestBody Customer_Register_Request customerRegisterRequest) {
        return registration_service.registerCustomer(new Customer_Register_Request());
    }

    @PostMapping("/seller/register")
    public String register(@RequestBody SellerRegistrationRequest  sellerRegistrationRequest){
        return registration_service.registerSeller(sellerRegistrationRequest);
    }
}