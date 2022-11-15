package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.CustomerController;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.CustomerService.Customer_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class Customer_Controller<CustomerDetails>
{
    @Autowired
    Customer_Service customerService;



    @PostMapping("/customer")
    public void createCustomer(@RequestBody CustomerDetails customer){
        System.out.println(customer.toString());
        customerService.createCustomer(customer);
    }
}

